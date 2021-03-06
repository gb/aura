/*
 * Copyright (C) 2013 salesforce.com, inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
({
    afterRender : function(component, helper) {
        this.superAfterRender();
        helper.initAfterRender(component);
    },

    rerender : function(component, helper) {
        var enabled = $A.util.getBooleanValue(component.get("v.enabled"));

        this.superRerender();

        if (enabled) {
            if (!component._scroller) {
                helper.initAfterRender(component);
            }
        } else {
            helper.deactivate(component);
        }
    },

    unrender : function(component, helper) {
        helper.deactivate(component);
        this.superUnrender();
    }
})
