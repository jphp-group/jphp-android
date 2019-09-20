package org.venity.jphp.ext.android.fx.classes;

import javafx.collections.ObservableList;
import javafx.geometry.Side;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import org.venity.jphp.ext.android.AndroidExtension;
import org.venity.jphp.ext.android.fx.support.control.TabPaneEx;
import org.venity.jphp.ext.android.fx.JavaFXExtension;
import php.runtime.annotation.Reflection;
import php.runtime.annotation.Reflection.*;
import php.runtime.env.Environment;
import php.runtime.reflection.ClassEntity;

@Name("UXTabPane")
@Reflection.Namespace(AndroidExtension.NS_FX)
public class UXTabPane extends UXControl<TabPane> {
    interface WrappedInterface {
        @Property Side side();
        @Property ObservableList<Tab> tabs();

        @Property double tabMaxWidth();
        @Property double tabMaxHeight();
        @Property double tabMinHeight();
        @Property double tabMinWidth();

        @Property TabPane.TabClosingPolicy tabClosingPolicy();
    }

    public UXTabPane(Environment env, TabPane wrappedObject) {
        super(env, wrappedObject);
    }

    public UXTabPane(Environment env, TabPaneEx wrappedObject) {
        super(env, wrappedObject);
    }

    public UXTabPane(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Signature
    public void __construct() {
        __wrappedObject = new TabPaneEx();
    }

    @Getter
    protected Tab getSelectedTab() {
        ObservableList<Tab> tabs = getWrappedObject().getTabs();

        for (Tab tab : tabs) {
            if (tab.isSelected()) {
                return tab;
            }
        }

        return null;
    }

    @Getter
    public int getSelectedIndex() {
        return getWrappedObject().getSelectionModel().getSelectedIndex();
    }

    @Setter
    public void setSelectedIndex(int index) {
        getWrappedObject().getSelectionModel().select(index);
    }

    @Setter
    protected void setSelectedTab(Tab tab) {
        selectTab(tab);
    }

    @Signature
    public void selectTab(Tab tab) {
        getWrappedObject().getSelectionModel().select(tab);
    }

    @Signature
    public void selectFirstTab() {
        getWrappedObject().getSelectionModel().selectFirst();
    }

    @Signature
    public void selectNextTab() {
        getWrappedObject().getSelectionModel().selectNext();
    }

    @Signature
    public void selectLastTab() {
        getWrappedObject().getSelectionModel().selectLast();
    }

    @Signature
    public void selectPreviousTab() {
        getWrappedObject().getSelectionModel().selectPrevious();
    }

    @Signature
    public void clearSelection() {
        getWrappedObject().getSelectionModel().clearSelection();
    }
}
