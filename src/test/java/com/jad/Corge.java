package com.jad;

public class Corge {
    private Foo foo;

    public Corge(Foo foo) {
        this.foo = foo;
    }

    public Foo getFoo() {
        return this.foo;
    }

    public void setFoo(Foo foo) {
        // détacher de l'ancien Foo
        if (this.foo != null && this.foo.getCorge() == this) {
            this.foo.setCorge(null);
        }
        this.foo = foo;
        // attacher au nouveau Foo
        if (foo != null && foo.getCorge() != this) {
            foo.setCorge(this);
        }
    }
}
