/*
 * Copyright 2015 Samsung Electronics Co., LTD
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */

package org.gearvrf.accessibility;

import org.gearvrf.GVRPerspectiveCamera;
import org.gearvrf.GVRScene;

public class GVRAccessibilityZoom {

    private static final float MAX_ZOOM = 45f;
    private static final float MIN_ZOOM = 90f;
    private static final float ZOOM_FACTOR = 5f;

    /**
     * Use this call to zoom into {@link GVRScene}s
     *
     * @param gvrScenes the scenes to zoom into
     *
     * @throws UnsupportedOperationException returns an exception when the camera rig attached to
     * the scene does not support this operation
     */
    public void zoomIn(GVRScene... gvrScenes) {
        for (GVRScene gvrScene : gvrScenes) {
            try {
                GVRPerspectiveCamera leftCameraMainScene = ((GVRPerspectiveCamera) gvrScene.getMainCameraRig().getLeftCamera());
                GVRPerspectiveCamera rightCameraMainScene = ((GVRPerspectiveCamera) gvrScene.getMainCameraRig().getRightCamera());
                if (leftCameraMainScene.getFovY() > MAX_ZOOM) {
                    leftCameraMainScene.setFovY(leftCameraMainScene.getFovY() - ZOOM_FACTOR);
                    rightCameraMainScene.setFovY(rightCameraMainScene.getFovY() - ZOOM_FACTOR);
                }
            } catch (ClassCastException e){
                throw new UnsupportedOperationException("Operation unsupported for this camera " +
                        "type");
            }

        }
    }

    /**
     * Use this call to zoom out of {@link GVRScene}s
     *
     * @param gvrScenes the scenes to zoom out of
     *
     * @throws UnsupportedOperationException returns an exception when the camera rig attached to
     * the scene does not support this operation
     */
    public void zoomOut(GVRScene... gvrScenes) {
        for (GVRScene gvrScene : gvrScenes) {
            try{
                GVRPerspectiveCamera leftCameraMainScene = ((GVRPerspectiveCamera) gvrScene.getMainCameraRig().getLeftCamera());
                GVRPerspectiveCamera rightCameraMainScene = ((GVRPerspectiveCamera) gvrScene.getMainCameraRig().getRightCamera());
                if (leftCameraMainScene.getFovY() < MIN_ZOOM) {
                    leftCameraMainScene.setFovY(leftCameraMainScene.getFovY() + ZOOM_FACTOR);
                    rightCameraMainScene.setFovY(rightCameraMainScene.getFovY() + ZOOM_FACTOR);
                }
            } catch (ClassCastException e){
                throw new UnsupportedOperationException("Operation unsupported for this camera " +
                        "type");
            }

        }
    }

}
