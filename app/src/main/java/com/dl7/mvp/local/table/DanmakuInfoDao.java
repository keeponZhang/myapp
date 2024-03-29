package com.dl7.mvp.local.table;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "DANMAKU_INFO".
*/
public class DanmakuInfoDao extends AbstractDao<DanmakuInfo, Void> {

    public static final String TABLENAME = "DANMAKU_INFO";

    /**
     * Properties of entity DanmakuInfo.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Type = new Property(0, int.class, "type", false, "TYPE");
        public final static Property Content = new Property(1, String.class, "content", false, "CONTENT");
        public final static Property Time = new Property(2, long.class, "time", false, "TIME");
        public final static Property TextSize = new Property(3, float.class, "textSize", false, "TEXT_SIZE");
        public final static Property TextColor = new Property(4, int.class, "textColor", false, "TEXT_COLOR");
        public final static Property UserName = new Property(5, String.class, "userName", false, "USER_NAME");
        public final static Property Vid = new Property(6, String.class, "vid", false, "VID");
    }


    public DanmakuInfoDao(DaoConfig config) {
        super(config);
    }
    
    public DanmakuInfoDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"DANMAKU_INFO\" (" + //
                "\"TYPE\" INTEGER NOT NULL ," + // 0: type
                "\"CONTENT\" TEXT," + // 1: content
                "\"TIME\" INTEGER NOT NULL ," + // 2: time
                "\"TEXT_SIZE\" REAL NOT NULL ," + // 3: textSize
                "\"TEXT_COLOR\" INTEGER NOT NULL ," + // 4: textColor
                "\"USER_NAME\" TEXT," + // 5: userName
                "\"VID\" TEXT);"); // 6: vid
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"DANMAKU_INFO\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, DanmakuInfo entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getType());
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(2, content);
        }
        stmt.bindLong(3, entity.getTime());
        stmt.bindDouble(4, entity.getTextSize());
        stmt.bindLong(5, entity.getTextColor());
 
        String userName = entity.getUserName();
        if (userName != null) {
            stmt.bindString(6, userName);
        }
 
        String vid = entity.getVid();
        if (vid != null) {
            stmt.bindString(7, vid);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, DanmakuInfo entity) {
        stmt.clearBindings();
        stmt.bindLong(1, entity.getType());
 
        String content = entity.getContent();
        if (content != null) {
            stmt.bindString(2, content);
        }
        stmt.bindLong(3, entity.getTime());
        stmt.bindDouble(4, entity.getTextSize());
        stmt.bindLong(5, entity.getTextColor());
 
        String userName = entity.getUserName();
        if (userName != null) {
            stmt.bindString(6, userName);
        }
 
        String vid = entity.getVid();
        if (vid != null) {
            stmt.bindString(7, vid);
        }
    }

    @Override
    public Void readKey(Cursor cursor, int offset) {
        return null;
    }    

    @Override
    public DanmakuInfo readEntity(Cursor cursor, int offset) {
        DanmakuInfo entity = new DanmakuInfo( //
            cursor.getInt(offset + 0), // type
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // content
            cursor.getLong(offset + 2), // time
            cursor.getFloat(offset + 3), // textSize
            cursor.getInt(offset + 4), // textColor
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // userName
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6) // vid
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, DanmakuInfo entity, int offset) {
        entity.setType(cursor.getInt(offset + 0));
        entity.setContent(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setTime(cursor.getLong(offset + 2));
        entity.setTextSize(cursor.getFloat(offset + 3));
        entity.setTextColor(cursor.getInt(offset + 4));
        entity.setUserName(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setVid(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
     }
    
    @Override
    protected final Void updateKeyAfterInsert(DanmakuInfo entity, long rowId) {
        // Unsupported or missing PK type
        return null;
    }
    
    @Override
    public Void getKey(DanmakuInfo entity) {
        return null;
    }

    @Override
    public boolean hasKey(DanmakuInfo entity) {
        // TODO
        return false;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
