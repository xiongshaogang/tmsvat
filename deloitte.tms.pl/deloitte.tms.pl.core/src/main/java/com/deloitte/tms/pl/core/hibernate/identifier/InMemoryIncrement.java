package com.deloitte.tms.pl.core.hibernate.identifier;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.id.PersistentIdentifierGenerator;
import org.hibernate.type.Type;

public final class InMemoryIncrement implements IdentifierGenerator, Configurable { 

    private static final Log log = LogFactory.getLog(InMemoryIncrement.class); 
     
    //存储最大值的数组的容量 
    private static final int MAX_CAPACITY = 200; 
     
    /**同步锁*/ 
    private static final Object lock = new Object(); 

    //存储表存储在数组中的索引值 
    private static Map map = new HashMap(); 
     
    //递增步长，默认加1 
    private int step = 1; 
     
    //最大值数组 
    private static long[] seqs = new long[MAX_CAPACITY]; 
     
    //最大值数组已经使用的容量 
    private static int lastIndex; 
     
    private String key; 
    private String sql; 
    private Connection connection; 
    private Class returnClass; 
     
    /** 
     * (none java doc) 
     * @see net.sf.hibernate.id.IdentifierGenerator# 
     * generate(net.sf.hibernate.engine.SessionImplementor, java.lang.Object) 
     */ 
    public Serializable generate(SessionImplementor session, Object object) 
    throws HibernateException { 
        connection = session.connection(); 
         
        long seq = -1; 
         
        //找到索引值 
        int index = findIndex(); 
         
        //把最大值加1 
        seqs[index] = seqs[index] + step; 
         
        seq = seqs[index]; 
         
        return new Long(seq); 
    } 

    /** 
     * 找到表中自动增长字段存储在数组中的索引值 
     * @return 索引值 
     */ 
    private int findIndex(){ 
        int index = 0; 
         
        //首先中缓存中取出索引值 
        Integer integer = (Integer)map.get(key); 
         
        //如果没有找到就从数据库中读出最大值并进行cache 
        if(null == integer){ 
            //double check lock 
            synchronized(lock){ 
                integer = (Integer)map.get(key); 
                if(null == integer){ 
                    long maxvalue = 1; 
                    try{ 
                        maxvalue = getMaxvalue(); 
                    }catch(SQLException e){ 
                        log.error(e); 
                    } 
                    integer = new Integer(lastIndex++); 
                    seqs[integer.intValue()] = maxvalue; 
                    map.put(key,integer);                 
                } 
            } 
        } 
         
        index = integer.intValue(); 
        return index; 
    }     
     
    /** 
     * (none java doc) 
     * @see net.sf.hibernate.id.Configurable#configure(net.sf.hibernate.type.Type, 
     * java.util.Properties, net.sf.hibernate.dialect.Dialect) 
     */ 
    public void configure(Type type, Properties params, Dialect d) 
    throws MappingException { 
         
        //取出table参数 
        String table = params.getProperty("table"); 
        if (table == null){ 
            table = params.getProperty(PersistentIdentifierGenerator.TABLE); 
        } 
        //取出column参数 
        String column = params.getProperty("column"); 
        if (column == null){ 
            column = params.getProperty(PersistentIdentifierGenerator.PK); 
        } 
         
        //表的sehcma参数 
        String schema = params.getProperty(PersistentIdentifierGenerator.SCHEMA); 
         
        returnClass = type.getReturnedClass(); 
         
        //取出step参数 
        String stepvalue = params.getProperty("step"); 
        if(null != stepvalue && !"".equals(stepvalue.trim())){ 
            try{ 
                step = Integer.parseInt(stepvalue); 
            }catch(Exception e){ 
                log.error(e); 
            } 
        } 
         

        //构造存储在Map中的索引值的key name 
        key = table + "_$_" + column; 
         
        //根据参数构造取最大值的SQL 
        sql = "select max(" + column + ") from "; 
        if(null != schema){ 
            sql += schema + "."; 
        } 
        sql += table; 
    } 
     
    /** 
     * 取指定表中id字段的最大值，不存在记录返回0 
     * @return 最大值 
     * @throws SQLException if sql error occurs. 
     */ 
    private long getMaxvalue() throws SQLException { 
        long maxvalue = 0; 
         
        PreparedStatement st = connection.prepareStatement(sql); 
        ResultSet rs = null; 
        try { 
            rs = st.executeQuery(); 
            if(rs.next()) { 
                maxvalue = rs.getLong(1); 
            } 
            sql = null; 
        }finally { 
            if (rs != null){ 
                rs.close(); 
            } 
            st.close(); 
        } 
        return maxvalue; 
    }
}