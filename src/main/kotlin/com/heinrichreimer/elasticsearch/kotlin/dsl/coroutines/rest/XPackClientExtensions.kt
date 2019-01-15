@file:Suppress("UNUSED")

package com.heinrichreimer.elasticsearch.kotlin.dsl.coroutines.rest

import com.heinrichreimer.elasticsearch.kotlin.dsl.coroutines.awaitAction
import com.heinrichreimer.elasticsearch.kotlin.dsl.rest.infoAsync
import com.heinrichreimer.elasticsearch.kotlin.dsl.rest.usageAsync
import org.elasticsearch.client.RequestOptions
import org.elasticsearch.client.XPackClient
import org.elasticsearch.client.xpack.XPackInfoRequest
import org.elasticsearch.client.xpack.XPackInfoResponse
import org.elasticsearch.client.xpack.XPackUsageRequest
import org.elasticsearch.client.xpack.XPackUsageResponse

suspend inline fun XPackClient.infoAsync(options: RequestOptions = RequestOptions.DEFAULT, block: XPackInfoRequest.() -> Unit = {}): XPackInfoResponse =
        awaitAction { infoAsync(options, it, block) }

suspend inline fun XPackClient.usageAsync(options: RequestOptions = RequestOptions.DEFAULT, block: XPackUsageRequest.() -> Unit = {}): XPackUsageResponse =
        awaitAction { usageAsync(options, it, block) }
