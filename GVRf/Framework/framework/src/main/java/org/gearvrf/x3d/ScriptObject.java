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

package org.gearvrf.x3d;

import org.gearvrf.script.GVRJavascriptScriptFile;
import org.gearvrf.utility.Log;

import java.util.ArrayList;

/**
 * @author m1.williams
 *         Class of an array list of Script objects
 *         These are constructed when parsing a SCRIPT node and
 *         SCRIPT nodes contain JavaScript file(s).
 *         <p/>
 *         Each Script object will contain an array list of
 *         Field objects, representing the FIELD node in the X3D file.
 *         A Field is INPUT and/or OUTPUT, an X3D data type, and a
 *         variable name used inside the JavaScript code.
 */


public class ScriptObject {

    public enum AccessType {
        INITIALIZE_ONLY, INPUT_ONLY, INPUT_OUTPUT, OUTPUT_ONLY
    }

    // name is the name of the variable
    // acceptType is from the enumated list above
    // type is the X3D data type such as SFColor, SFBool, etc.

    protected class Field {
        private String name = "";
        private AccessType accessType = null;
        private String type = "";
        private DefinedItem toDefinedItem = null;
        private DefinedItem fromDefinedItem = null;
        private String toDefinedItemField = ""; // fields from ROUTE's
        private String fromDefinedItemField = "";
    }

    ;

    private static final String TAG = Log.tag(ScriptObject.class);
    private ArrayList<Field> fields = new ArrayList<Field>();

    private String name = null;
    private Boolean directOutput = false;
    private Boolean mustEvaluate = false;
    private String[] url;

    private String javaScriptCode = null;
    private GVRJavascriptScriptFile gvrJavascriptScriptFile = null;
    private String gearVRinitJavaScript;  // A text function to construct X3D data types

    public ScriptObject() {
    }

    public ScriptObject(String name, Boolean directOutput, Boolean mustEvaluate, String[] url) {
        this.name = name;
        this.directOutput = directOutput;
        this.mustEvaluate = mustEvaluate;
        this.url = url;
    }

    public void addField(String name, AccessType accessType, String type) {
        Field field = new Field();
        field.name = name;
        field.accessType = accessType;
        field.type = type;
        fields.add(field);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Field> getFieldsArrayList() {
        return fields;
    }

    public Field getField(int i) {
        return fields.get(i);
    }

    public AccessType getFieldAccessType(Field field) {
        return field.accessType;
    }

    public String getFieldName(Field field) {
        return field.name;
    }

    public String getFieldType(Field field) {
        return field.type;
    }

    public DefinedItem getToDefinedItem(Field field) {
        return field.toDefinedItem;
    }

    public DefinedItem getFromDefinedItem(Field field) {
        return field.fromDefinedItem;
    }

    public String getToDefinedItemField(Field field) {
        return field.toDefinedItemField;
    }

    public String getFromDefinedItemField(Field field) {
        return field.fromDefinedItemField;
    }

    public void setToDefinedItem(Field field, DefinedItem definedItem, String toField) {
        field.toDefinedItem = definedItem;
        field.toDefinedItemField = toField;
    }

    public void setFromDefinedItem(Field field, DefinedItem definedItem, String fromField) {
        field.fromDefinedItem = definedItem;
        field.fromDefinedItemField = fromField;
    }

    public GVRJavascriptScriptFile getGVRJavascriptScriptFile() {
        return this.gvrJavascriptScriptFile;
    }

    public void setGVRJavascriptScriptFile(GVRJavascriptScriptFile gvrJavascriptScriptFile) {
        this.gvrJavascriptScriptFile = gvrJavascriptScriptFile;
    }

    public String getJavaScriptCode() {
        return this.javaScriptCode;
    }

    public void setJavaScriptCode(String javaScriptCode) {
        this.javaScriptCode = javaScriptCode;
    }

    public String getGearVRinitJavaScript() {
        return this.gearVRinitJavaScript;
    }

    public void setGearVRinitJavaScript(String gearVRinitJavaScript) {
        this.gearVRinitJavaScript = gearVRinitJavaScript;
    }


}



