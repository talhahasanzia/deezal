package com.talhahasanzia.deezal.commons.network
/**
 * To make App-wide DTOs consistent, every DTO must implement this interface.
 */
interface BaseResponseDto {
    // a default field that is usually present in every ReST API response
    var success: Boolean
}