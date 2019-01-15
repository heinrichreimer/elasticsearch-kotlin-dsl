@file:Suppress("UNUSED")

package com.heinrichreimer.elasticsearch.kotlin.dsl.coroutines.rest

import com.heinrichreimer.elasticsearch.kotlin.dsl.coroutines.awaitAction
import com.heinrichreimer.elasticsearch.kotlin.dsl.rest.getSettingsAsync
import com.heinrichreimer.elasticsearch.kotlin.dsl.rest.healthAsync
import com.heinrichreimer.elasticsearch.kotlin.dsl.rest.putSettingsAsync
import org.elasticsearch.action.admin.cluster.health.ClusterHealthRequest
import org.elasticsearch.action.admin.cluster.health.ClusterHealthResponse
import org.elasticsearch.action.admin.cluster.settings.ClusterGetSettingsRequest
import org.elasticsearch.action.admin.cluster.settings.ClusterGetSettingsResponse
import org.elasticsearch.action.admin.cluster.settings.ClusterUpdateSettingsRequest
import org.elasticsearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse
import org.elasticsearch.client.ClusterClient
import org.elasticsearch.client.RequestOptions

suspend inline fun ClusterClient.putSettingsAsync(options: RequestOptions = RequestOptions.DEFAULT, block: ClusterUpdateSettingsRequest.() -> Unit = {}): ClusterUpdateSettingsResponse =
        awaitAction { putSettingsAsync(options, it, block) }

suspend inline fun ClusterClient.getSettingsAsync(options: RequestOptions = RequestOptions.DEFAULT, block: ClusterGetSettingsRequest.() -> Unit = {}): ClusterGetSettingsResponse =
        awaitAction { getSettingsAsync(options, it, block) }

suspend inline fun ClusterClient.healthAsync(options: RequestOptions = RequestOptions.DEFAULT, block: ClusterHealthRequest.() -> Unit = {}): ClusterHealthResponse =
        awaitAction { healthAsync(options, it, block) }
