package com.check.network.grpc

import io.grpc.CallCredentials
import io.grpc.Metadata
import io.grpc.Status
import java.util.concurrent.Executor

class CustomCredentials internal constructor(private val token: String) : CallCredentials() {
    override fun applyRequestMetadata(
        requestInfo: RequestInfo, executor: Executor,
        metadataApplier: MetadataApplier
    ) {
        executor.execute {
            try {
                val headers = Metadata()
                headers.put(AUTHORIZATION_METADATA_KEY, token)
                metadataApplier.apply(headers)
            } catch (e: Throwable) {
                metadataApplier.fail(Status.UNAUTHENTICATED.withCause(e))
            }
        }
    }
}