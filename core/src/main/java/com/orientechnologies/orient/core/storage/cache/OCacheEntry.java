/*
 *
 *  *  Copyright 2010-2016 OrientDB LTD (http://orientdb.com)
 *  *
 *  *  Licensed under the Apache License, Version 2.0 (the "License");
 *  *  you may not use this file except in compliance with the License.
 *  *  You may obtain a copy of the License at
 *  *
 *  *       http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *  Unless required by applicable law or agreed to in writing, software
 *  *  distributed under the License is distributed on an "AS IS" BASIS,
 *  *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *  See the License for the specific language governing permissions and
 *  *  limitations under the License.
 *  *
 *  * For more information: http://orientdb.com
 *
 */

package com.orientechnologies.orient.core.storage.cache;

import com.orientechnologies.orient.core.storage.impl.local.paginated.wal.OLogSequenceNumber;
import com.orientechnologies.orient.core.storage.impl.local.paginated.wal.OWALChanges;

/**
 * @author Andrey Lomakin (a.lomakin-at-orientdb.com)
 * @since 7/23/13
 */
public interface OCacheEntry {
  OCachePointer getCachePointer();

  void clearCachePointer();

  void setCachePointer(OCachePointer cachePointer);

  long getFileId();

  long getPageIndex();

  void acquireExclusiveLock();

  void releaseExclusiveLock();

  void acquireSharedLock();

  void releaseSharedLock();

  int getUsagesCount();

  void incrementUsages();

  /**
   * DEBUG only !!
   *
   * @return Whether lock acquired on current entry
   */
  boolean isLockAcquiredByCurrentThread();

  void decrementUsages();

  OWALChanges getChanges();

  OLogSequenceNumber getEndLSN();

  void setEndLSN(OLogSequenceNumber endLSN);
}
