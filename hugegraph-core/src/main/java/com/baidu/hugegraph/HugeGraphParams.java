/*
 * Copyright 2017 HugeGraph Authors
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.baidu.hugegraph;

import com.baidu.hugegraph.analyzer.Analyzer;
import com.baidu.hugegraph.backend.serializer.AbstractSerializer;
import com.baidu.hugegraph.backend.store.BackendFeatures;
import com.baidu.hugegraph.backend.store.BackendStore;
import com.baidu.hugegraph.backend.store.ram.RamTable;
import com.baidu.hugegraph.backend.tx.GraphTransaction;
import com.baidu.hugegraph.backend.tx.SchemaTransaction;
import com.baidu.hugegraph.config.HugeConfig;
import com.baidu.hugegraph.event.EventHub;
import com.baidu.hugegraph.task.ServerInfoManager;
import com.baidu.hugegraph.type.define.GraphMode;
import com.baidu.hugegraph.type.define.GraphReadMode;
import com.google.common.util.concurrent.RateLimiter;

/**
 * Graph inner Params interface
 */
public interface HugeGraphParams {

    HugeGraph graph();

    String name();

    GraphMode mode();

    GraphReadMode readMode();

    SchemaTransaction schemaTransaction();

    GraphTransaction systemTransaction();

    GraphTransaction graphTransaction();

    GraphTransaction openTransaction();

    void closeTx();

    boolean started();

    boolean closed();

    boolean initialized();

    BackendFeatures backendStoreFeatures();

    BackendStore loadSchemaStore();

    BackendStore loadGraphStore();

    BackendStore loadSystemStore();

    EventHub schemaEventHub();

    EventHub graphEventHub();

    EventHub indexEventHub();

    HugeConfig configuration();

    ServerInfoManager serverManager();

    AbstractSerializer serializer();

    Analyzer analyzer();

    RateLimiter writeRateLimiter();

    RateLimiter readRateLimiter();

    RamTable ramtable();
}
