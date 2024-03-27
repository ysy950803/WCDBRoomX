package com.ysy.wcdbroomx

import com.tencent.wcdb.database.SQLiteCipherSpec

object WCDBRoomX {

    init {
        System.loadLibrary("sqlcipher")
    }

    private val sqLiteCipherSpec
        get() = SQLiteCipherSpec().setPageSize(4096).setSQLCipherVersion(3)

    fun createOpenHelperFactory(passphrase: String): WCDBOpenHelperFactory =
        createOpenHelperFactory(passphrase.toByteArray())

    fun createOpenHelperFactory(passphrase: ByteArray): WCDBOpenHelperFactory =
        WCDBOpenHelperFactory()
            .passphrase(passphrase) // passphrase to the database, remove this line for plain-text
            .cipherSpec(sqLiteCipherSpec) // cipher to use, remove for default settings
            .writeAheadLoggingEnabled(true) // enable WAL mode, remove if not needed
            .asyncCheckpointEnabled(true) // enable asynchronous checkpoint, remove if not needed
}
