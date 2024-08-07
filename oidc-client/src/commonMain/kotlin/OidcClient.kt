/*
 *	Copyright 2023 cufy.org and meemer.com
 *
 *	Licensed under the Apache License, Version 2.0 (the "License");
 *	you may not use this file except in compliance with the License.
 *	You may obtain a copy of the License at
 *
 *	    http://www.apache.org/licenses/LICENSE-2.0
 *
 *	Unless required by applicable law or agreed to in writing, software
 *	distributed under the License is distributed on an "AS IS" BASIS,
 *	WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *	See the License for the specific language governing permissions and
 *	limitations under the License.
 */
package net.lsafer.oidc.client

import io.ktor.client.*
import io.ktor.client.engine.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.util.*

open class OidcClient(val httpClient: HttpClient)

fun OidcClient(
    block: HttpClientConfig<*>.() -> Unit = {},
): OidcClient = OidcClient(HttpClient {
    initOidcClient()
    block()
})

fun <T : HttpClientEngineConfig> OidcClient(
    engineFactory: HttpClientEngineFactory<T>,
    block: HttpClientConfig<T>.() -> Unit = {},
): OidcClient = OidcClient(HttpClient(engineFactory) {
    initOidcClient()
    block()
})

@KtorDsl
fun OidcClient(
    engine: HttpClientEngine,
    block: HttpClientConfig<*>.() -> Unit,
): OidcClient = OidcClient(HttpClient(engine) {
    initOidcClient()
    block()
})

private fun HttpClientConfig<*>.initOidcClient() {
    install(ContentNegotiation) {
        json()
    }

    expectSuccess = true
}
