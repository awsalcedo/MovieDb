package com.asalcedo.moviedb.core.data.remote.extensions

import retrofit2.HttpException
import java.util.concurrent.CancellationException

inline fun <T, R> T.resultOf(block: T.() -> R): Result<R> {
    return try {
        Result.success(block())
    } catch (e: CancellationException) { //Cancel coroutines
        Result.failure(e)
    } catch (e: HttpException) { // Managment custom http exceptions
        Result.failure(e)
    } catch (e: Exception) {
        Result.failure(e)
    }
}