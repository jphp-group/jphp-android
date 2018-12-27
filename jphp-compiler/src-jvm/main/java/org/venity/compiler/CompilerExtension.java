package org.venity.compiler;

import php.runtime.env.CompileScope;
import php.runtime.ext.support.Extension;

public class CompilerExtension extends Extension {
    @Override
    public Status getStatus() {
        return null;
    }

    @Override
    public void onRegister(CompileScope compileScope) {
        registerClass(compileScope, WrapCompilerClassLoader.class);
    }
}