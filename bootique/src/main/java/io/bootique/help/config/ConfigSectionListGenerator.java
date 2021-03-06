/*
 * Licensed to ObjectStyle LLC under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ObjectStyle LLC licenses
 * this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package io.bootique.help.config;

import io.bootique.help.ConsoleAppender;
import io.bootique.meta.config.ConfigValueMetadata;

/**
 * @since 0.21
 */
class ConfigSectionListGenerator extends ConfigSectionGenerator {

    public ConfigSectionListGenerator(ConsoleAppender out) {
        super(out);
    }

    @Override
    protected void printNode(ConfigValueMetadata metadata, boolean asValue) {

        if (asValue) {
            String valueLabel = metadata.getValueLabel();
            out.println("- ", valueLabel);
        } else {
            out.println("-");
        }
    }
}
