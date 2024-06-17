package com.example.citydbcompose.data

sealed class ConnectionStatus {

    object Available: ConnectionStatus()
    object Unavailable: ConnectionStatus()
}