/*
 * Copyright 2010-2012 Luca Garulli (l.garulli--at--orientechnologies.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.orientechnologies.orient.core.db.record;

import com.orientechnologies.orient.core.db.ODatabaseComplexInternal;
import com.orientechnologies.orient.core.db.record.ridbag.sbtree.OSBTreeCollectionManager;
import com.orientechnologies.orient.core.record.ORecord;
import com.orientechnologies.orient.core.serialization.serializer.binary.OBinarySerializerFactory;
import com.orientechnologies.orient.core.serialization.serializer.record.ORecordSerializer;

/**
 * Generic interface for record based Database implementations.
 * 
 * @author Luca Garulli
 */
public interface ODatabaseRecordInternal extends ODatabaseRecord, ODatabaseComplexInternal<ORecord> {

  /**
   * Internal. Returns the factory that defines a set of components that current database should use to be compatible to current
   * version of storage. So if you open a database create with old version of OrientDB it defines a components that should be used
   * to provide backward compatibility with that version of database.
   */
  public OCurrentStorageComponentsFactory getStorageVersions();

  /**
   * Internal. Gets an instance of sb-tree collection manager for current database.
   */
  public OSBTreeCollectionManager getSbTreeCollectionManager();

  /**
   * @return the factory of binary serializers.
   */
  public OBinarySerializerFactory getSerializerFactory();

  /**
   * @return serializer which is used for document serialization.
   */
  public ORecordSerializer getSerializer();
}
