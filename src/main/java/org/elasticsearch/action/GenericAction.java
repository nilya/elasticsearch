/*
 * Licensed to ElasticSearch and Shay Banon under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. ElasticSearch licenses this
 * file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.action;

import org.elasticsearch.transport.TransportRequestOptions;

/**
 * A generic action. Should strive to make it a singleton.
 */
public abstract class GenericAction<Request extends ActionRequest, Response extends ActionResponse> {

    private final String name;

    /**
     * @param name The name of the action, must be unique across actions.
     */
    protected GenericAction(String name) {
        this.name = name;
    }

    /**
     * The name of the action. Must be unique across actions.
     */
    public String name() {
        return this.name;
    }

    /**
     * Creates a new response instance.
     */
    public abstract Response newResponse();

    /**
     * Optional request options for the action.
     */
    public TransportRequestOptions options() {
        return TransportRequestOptions.EMPTY;
    }

    @Override
    public boolean equals(Object o) {
        return name.equals(((GenericAction) o).name());
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}