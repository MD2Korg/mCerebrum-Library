/*
 * Copyright (c) 2018, The University of Memphis, MD2K Center of Excellence
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 * list of conditions and the following disclaimer.
 *
 * * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation
 * and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.md2k.mcerebrum.system.appinfo;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import org.md2k.mcerebrum.core.constant.MCEREBRUM;

/**
 * Sends broadcast messages with the intent <code>"org.md2k.mcerebrum.intent.action.RECEIVE"</code>.
 */
public class BroadCastMessage {

    /** Constant used for logging. <p>Uses <code>class.getSimpleName()</code>.</p> */
    private static final String TAG = BroadCastMessage.class.getSimpleName();

    /**
     * Sends a new broadcast with a receive intent.
     *
     * @param context Android context.
     */
    public static void send(Context context){
        Intent i = new Intent("org.md2k.mcerebrum.intent.action.RECEIVE");
        Log.d(TAG, "broadcast send...");
        context.sendBroadcast(i);
    }

    /**
     * Sends a new broadcast with a receive intent and an extra <code>operation</code>.
     *
     * @param context Android context.
     * @param operation Operation to add to the intent.
     */
    public static void send(Context context, String operation){
        Intent i = new Intent("org.md2k.mcerebrum.intent.action.RECEIVE");
        i.putExtra(MCEREBRUM.APP_ACCESS.OP, operation);
        Log.d(TAG, "broadcast send...op=" + operation);
        context.sendBroadcast(i);
    }
}
