package com.antonioleiva.marvelcompose.data.network

import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

private fun md5(stringToHash: String): String {
    val md5 = "MD5"

    try {
        val digest = MessageDigest.getInstance(md5)
        digest.update(stringToHash.toByteArray())
        val messageDigest = digest.digest()

        val hexString = StringBuilder()
        for (aMessageDigest in messageDigest) {
            var h = Integer.toHexString(0xFF and aMessageDigest.toInt())
            while (h.length < 2) {
                h = "0$h"
            }
            hexString.append(h)
        }
        return hexString.toString()

    } catch (e: NoSuchAlgorithmException) {
        e.printStackTrace()
    }

    return ""
}

fun generateHash(time: Long, privateKey: String, publicKey: String): String =
    md5(time.toString() + privateKey + publicKey)