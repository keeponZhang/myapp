/*
 * Copyright (C) 2011-2016 Markus Junginger, greenrobot (http://greenrobot.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.greenrobot.greendao;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.identityscope.IdentityScopeType;
import org.greenrobot.greendao.internal.DaoConfig;

import java.util.HashMap;
import java.util.Map;

/**
 * The master of dao will guide you: start dao sessions with the master.
 * 
 * @author Markus
 */
public abstract class AbstractDaoMaster {
    protected final Database db;
    protected final int schemaVersion;
//    看这个类的代码，其中最让我们受关注的无非就是这一行了
//    这里定义了一个Map集合，Key是继承自AbstractDao类的字节码对象，Value则为DaoConfig对象。
//    每个AbstractDao对应着一个DaoConfig，然后保存在Map< Class<? extends AbstractDao<?, ?>>, DaoConfig> daoConfigMap中，
//    DaoConfig这个类的作用，一是通过反射的方式获取到AbstractDao对应的表名、表中所有字段（主键、非主键greendao中用Property对象来保存一个字段的信息）等相关信息，
//    然后利用这些信息创建了辅助类TableStatements的一个实例，TableStatements这个类的作用是创建操作table的SQL语句；二是获取该表对应的缓存处理实例。
    protected final Map<Class<? extends AbstractDao<?, ?>>, DaoConfig> daoConfigMap;
//    所以Map的功能现在很清楚了，就是为每一个EntityDao字节码对象建立与之对应的db数据库的映射关系，从而管理所有的EntityDao类。
//    而这个方法在哪里调用了呢？我们回到DaoMaster的源码中，发现在DaoMaster类的构造方法中调用了，并且传入了Student.class，所以我们在创建DaoMaster对象的时候也同时为EntityDao类和相应的数据库db建立好了关联。
    public AbstractDaoMaster(Database db, int schemaVersion) {
        this.db = db;
        this.schemaVersion = schemaVersion;

        daoConfigMap = new HashMap<Class<? extends AbstractDao<?, ?>>, DaoConfig>();
    }

    protected void registerDaoClass(Class<? extends AbstractDao<?, ?>> daoClass) {
        DaoConfig daoConfig = new DaoConfig(db, daoClass);
        daoConfigMap.put(daoClass, daoConfig);
    }

    public int getSchemaVersion() {
        return schemaVersion;
    }

    /** Gets the SQLiteDatabase for custom database access. Not needed for greenDAO entities. */
    public Database getDatabase() {
        return db;
    }

    public abstract AbstractDaoSession newSession();

    public abstract AbstractDaoSession newSession(IdentityScopeType type);
}
