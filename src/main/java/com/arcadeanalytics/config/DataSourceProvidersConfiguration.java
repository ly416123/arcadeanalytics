package com.arcadeanalytics.config;

/*-
 * #%L
 * Arcade Analytics
 * %%
 * Copyright (C) 2018 - 2019 ArcadeAnalytics
 * %%
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
 * #L%
 */

import com.arcadeanalytics.provider.DataSourceGraphDataProvider;
import com.arcadeanalytics.provider.DataSourceGraphProvider;
import com.arcadeanalytics.provider.DataSourceMetadataProvider;
import com.arcadeanalytics.provider.DataSourceProviderFactory;
import com.arcadeanalytics.provider.DataSourceTableDataProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.io.IOException;

@Configuration
public class DataSourceProvidersConfiguration {
    private final Logger log = LoggerFactory.getLogger(DataSourceProvidersConfiguration.class);

    private final String path;


    public DataSourceProvidersConfiguration(Environment env) throws IOException {

        path = env.getProperty("application.connectorsPath");

        log.info("connectors paths:: {} ", path);
    }

    @Bean
    public DataSourceProviderFactory<DataSourceGraphDataProvider> dataSourceGraphDataProviderFactory() {

        return new DataSourceProviderFactory<DataSourceGraphDataProvider>(DataSourceGraphDataProvider.class, path);
    }

    @Bean
    public DataSourceProviderFactory<DataSourceGraphProvider> dataSourceGraphProviderFactory() {

        return new DataSourceProviderFactory<DataSourceGraphProvider>(DataSourceGraphProvider.class, path);
    }


    @Bean
    public DataSourceProviderFactory<DataSourceMetadataProvider> dataSourceMetadataProviderFactory() {

        return new DataSourceProviderFactory<DataSourceMetadataProvider>(DataSourceMetadataProvider.class, path);
    }

    @Bean
    public DataSourceProviderFactory<DataSourceTableDataProvider> dataSourceTableDataProviderFactory() {

        return new DataSourceProviderFactory<DataSourceTableDataProvider>(DataSourceTableDataProvider.class, path);
    }

}
