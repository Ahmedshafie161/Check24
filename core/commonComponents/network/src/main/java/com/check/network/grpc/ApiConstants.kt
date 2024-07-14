package com.check.network.grpc

import io.grpc.Metadata.ASCII_STRING_MARSHALLER
import io.grpc.Context
import io.grpc.Metadata


const val JWT_SIGNING_KEY = ""
const val BEARER_TYPE = "Bearer"

val AUTHORIZATION_METADATA_KEY: Metadata.Key<String> =
    Metadata.Key.of("authorization", ASCII_STRING_MARSHALLER)
val CLIENT_ID_CONTEXT_KEY: Context.Key<String> = Context.key("clientId")