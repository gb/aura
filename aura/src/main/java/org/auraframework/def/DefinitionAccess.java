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


package org.auraframework.def;

import java.util.Set;

import org.auraframework.system.AuraContext;
import org.auraframework.throwable.quickfix.InvalidAccessValueException;

// Holds compiled value of ACCESS attribute. 
public interface DefinitionAccess {
	
    public enum BasicAccessType {
    	AUTHENTICATED, UNAUTHENTICATED, PUBLIC, GLOBAL, PRIVATE, 
    	PREVIEW, INTERNAL
    };
    
    // Authentication
    boolean requiresAuthentication();
    // Scope
    boolean isGlobal();
    boolean isPublic();
    boolean isPrivate();
    // Access (to be evaluated in current context)
    boolean isAccessible();
    
    // Validation
    void validate(Set<BasicAccessType> allowed) throws InvalidAccessValueException ;
    
}