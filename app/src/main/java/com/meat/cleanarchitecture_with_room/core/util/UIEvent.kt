package com.meat.cleanarchitecture_with_room.core.util

sealed class UIEvent {
    data class ShowSnackbar( val message:String):UIEvent()
}