package com.jad;

import java.util.ArrayList;
import java.util.List;

public class Foo {
    private final Bar bar;
    private final List<Baz> bazs;
    private final Qux qux;
    private final List<Grault> graults;
    private Corge corge;

    // Foo(bar: Bar)
    public Foo(Bar bar) {
        this.bar = bar;
        this.bazs = new ArrayList<>();
        this.qux = new Qux();
        this.corge = null;
        this.graults = new ArrayList<>();
    }


    public Bar getBar() {
        return this.bar;
    }

    public void addBaz(Baz baz) {
        if (baz != null) this.bazs.add(baz);
    }

    public List<Baz> getBazs() {
        return this.bazs;
    }

    public Qux getQux() {
        return this.qux;
    }

    public Corge getCorge() {
        return this.corge;
    }

    public void setCorge(Corge corge) {
        // détacher l'ancien
        if (this.corge != null && this.corge.getFoo() == this) {
            // mettre à null côté Corge sans reboucler
            this.corgeSetFooNull(this.corge);
        }
        this.corge = corge;
        // attacher le nouveau
        if (corge != null && corge.getFoo() != this) {
            corge.setFoo(this);
        }
    }


    private void corgeSetFooNull(Corge corge) {

        corge.setFoo(null);
    }

    public List<Grault> getGraults() {
        return this.graults;
    }

    public void addGrault() {
        this.graults.add(new Grault(this));
    }
}
