/* Copyright 2016 Samsung Electronics Co., LTD
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gearvrf;

import org.gearvrf.utility.VrAppSettings;

import android.app.Activity;

class OvrActivityNative implements IActivityNative {
    static {
        System.loadLibrary("gvrf-oculus");
    }

    private final long mPtr;

    OvrActivityNative(Activity act, VrAppSettings vrAppSettings) {
        mPtr = onCreate(act, vrAppSettings);
    }

    public void onDestroy() {
        onDestroy(mPtr);
    }

    public void setCameraRig(GVRCameraRig cameraRig) {
        setCameraRig(mPtr, cameraRig.getNative());
    }

    public void onUndock() {
        onUndock(mPtr);
    }

    public void onDock() {
        onDock(mPtr);
    }

    public long getNative() {
        return mPtr;
    }

    public void setViewManager(OvrViewManager viewManager) {
        setViewManager(mPtr, viewManager);
    }

    private static native void setCameraRig(long appPtr, long cameraRig);

    private static native void onDock(long appPtr);

    private static native void onUndock(long appPtr);

    private static native void onDestroy(long appPtr);

    private static native long onCreate(Activity act, VrAppSettings vrAppSettings);

    private static native void setViewManager(long appPtr, OvrViewManager viewManager);
}
