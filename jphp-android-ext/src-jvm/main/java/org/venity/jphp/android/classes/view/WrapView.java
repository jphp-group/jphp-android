package org.venity.jphp.android.classes.view;

import android.app.Activity;
import android.content.Context;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import org.venity.jphp.android.AndroidExtension;
import php.runtime.Memory;
import php.runtime.annotation.Reflection;
import php.runtime.env.Environment;
import php.runtime.ext.java.JavaException;
import php.runtime.invoke.Invoker;
import php.runtime.lang.BaseException;
import php.runtime.lang.BaseWrapper;
import php.runtime.lang.spl.exception.RuntimeException;
import php.runtime.reflection.ClassEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Reflection.Name("View")
@Reflection.Namespace(AndroidExtension.VIEW_NS)
public class WrapView extends BaseWrapper<View> {

    public static final int NO_ID = -1;
    public static final int VISIBLE = 0;
    public static final int INVISIBLE = 4;
    public static final int GONE = 8;
    public static final int DRAWING_CACHE_QUALITY_LOW = 524288;
    public static final int DRAWING_CACHE_QUALITY_HIGH = 1048576;
    public static final int DRAWING_CACHE_QUALITY_AUTO = 0;
    public static final int SCROLLBARS_INSIDE_OVERLAY = 0;
    public static final int SCROLLBARS_INSIDE_INSET = 16777216;
    public static final int SCROLLBARS_OUTSIDE_OVERLAY = 33554432;
    public static final int SCROLLBARS_OUTSIDE_INSET = 50331648;
    public static final int KEEP_SCREEN_ON = 67108864;
    public static final int SOUND_EFFECTS_ENABLED = 134217728;
    public static final int HAPTIC_FEEDBACK_ENABLED = 268435456;
    public static final int FOCUSABLES_ALL = 0;
    public static final int FOCUSABLES_TOUCH_MODE = 1;
    public static final int FOCUS_BACKWARD = 1;
    public static final int FOCUS_FORWARD = 2;
    public static final int FOCUS_LEFT = 17;
    public static final int FOCUS_UP = 33;
    public static final int FOCUS_RIGHT = 66;
    public static final int FOCUS_DOWN = 130;
    public static final int MEASURED_SIZE_MASK = 16777215;
    public static final int MEASURED_STATE_MASK = -16777216;
    public static final int MEASURED_HEIGHT_STATE_SHIFT = 16;
    public static final int MEASURED_STATE_TOO_SMALL = 16777216;

    public static final int TEXT_ALIGNMENT_INHERIT = 0;
    public static final int TEXT_ALIGNMENT_RESOLVED_DEFAULT = 131072;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_AUTO = 0;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_YES = 1;
    public static final int IMPORTANT_FOR_ACCESSIBILITY_NO = 2;
    public static final int OVER_SCROLL_ALWAYS = 0;
    public static final int OVER_SCROLL_IF_CONTENT_SCROLLS = 1;
    public static final int OVER_SCROLL_NEVER = 2;
    public static final int SYSTEM_UI_FLAG_VISIBLE = 0;
    public static final int SYSTEM_UI_FLAG_LOW_PROFILE = 1;
    public static final int SYSTEM_UI_FLAG_HIDE_NAVIGATION = 2;
    public static final int SYSTEM_UI_FLAG_FULLSCREEN = 4;
    public static final int SYSTEM_UI_FLAG_LAYOUT_STABLE = 256;
    public static final int SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION = 512;
    public static final int SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN = 1024;

    public static final int SYSTEM_UI_LAYOUT_FLAGS = 1536;
    public static final int FIND_VIEWS_WITH_TEXT = 1;
    public static final int FIND_VIEWS_WITH_CONTENT_DESCRIPTION = 2;
    public static final int SCREEN_STATE_OFF = 0;
    public static final int SCREEN_STATE_ON = 1;
    public static final int SCROLLBAR_POSITION_DEFAULT = 0;
    public static final int SCROLLBAR_POSITION_LEFT = 1;
    public static final int SCROLLBAR_POSITION_RIGHT = 2;
    public static final int LAYER_TYPE_NONE = 0;
    public static final int LAYER_TYPE_SOFTWARE = 1;
    public static final int LAYER_TYPE_HARDWARE = 2;

    protected final static AtomicInteger idCounter = new AtomicInteger(100000);

    public WrapView(Environment env, View wrappedObject) {
        super(env, wrappedObject);
    }

    public WrapView(Environment env, ClassEntity clazz) {
        super(env, clazz);
    }

    @Reflection.Signature
    public void __construct(Context activity)
    {
        __wrappedObject = new View(activity);
    }

    @Reflection.Signature
    public void on(String event, Invoker callback) {
        switch (event.toLowerCase()) {
            case "click":
                __wrappedObject.setOnClickListener(view ->
                        callback.callNoThrow(Memory.wrap(__env__, view)));
                break;
            case "touch":
                __wrappedObject.setOnTouchListener((view, motionEvent) ->
                        callback.callNoThrow(Memory.wrap(__env__, view)).toBoolean());
                break;
            case "long-click":
                __wrappedObject.setOnLongClickListener(view ->
                        callback.callNoThrow(Memory.wrap(__env__, view)).toBoolean());
                break;
            case "hover":
                __wrappedObject.setOnHoverListener((view, motionEvent) ->
                        callback.callNoThrow(Memory.wrap(__env__, view)).toBoolean());
                break;
            case "drag":
                __wrappedObject.setOnDragListener((view, dragEvent) ->
                        callback.callNoThrow(Memory.wrap(__env__, view)).toBoolean());
                break;
            case "key":
                __wrappedObject.setOnKeyListener((view, i, keyEvent) ->
                        callback.callNoThrow(Memory.wrap(__env__, view)).toBoolean());
                break;
            case "focus":
                __wrappedObject.setOnFocusChangeListener((view, b) ->
                        callback.callNoThrow(Memory.wrap(__env__, view), Memory.wrap(__env__, b)));
                break;
            default:
                __env__.exception(new RuntimeException(__env__), "Event " + event.toUpperCase() + " not found!");
        }
    }

    @Reflection.Signature
    public void off(String event) {
        switch (event.toLowerCase()) {
            case "click":
                __wrappedObject.setOnClickListener(null);
                break;
            case "touch":
                __wrappedObject.setOnTouchListener(null);
                break;
            case "long-click":
                __wrappedObject.setOnLongClickListener(null);
                break;
            case "hover":
                __wrappedObject.setOnHoverListener(null);
                break;
            case "drag":
                __wrappedObject.setOnDragListener(null);
                break;
            case "key":
                __wrappedObject.setOnKeyListener(null);
                break;
            case "focus":
                __wrappedObject.setOnFocusChangeListener(null);
                break;
            default:
                __env__.exception(new RuntimeException(__env__), "Event " + event.toUpperCase() + " not found!");
        }
    }

    @Reflection.Signature
    public void trigger(String event) {
        switch (event.toLowerCase()) {
            case "click":
                __wrappedObject.callOnClick();
                break;

            case "focus":
            case "key":
            case "drag":
            case "hover":
            case "touch":
            case "long-click":
                // noop.
                break;
            default:
                __env__.exception(new RuntimeException(__env__), "Event " + event.toUpperCase() + " not found!");
        }
    }

    @Reflection.Setter
    public void setId(int id) {
        getWrappedObject().setId(id);
    }

    @Reflection.Getter
    public int getId() {
        return getWrappedObject().getId();
    }

    @Reflection.Setter
    public void setTop(int top) {
        getWrappedObject().setTop(top);
    }

    @Reflection.Getter
    public int getTop() {
        return getWrappedObject().getTop();
    }

    @Reflection.Setter
    public void setBottom(int bottom) {
        getWrappedObject().setBottom(bottom);
    }

    @Reflection.Getter
    public int getBottom() {
        return getWrappedObject().getBottom();
    }

    @Reflection.Setter
    public void setLeft(int left) {
        getWrappedObject().setLeft(left);
    }

    @Reflection.Getter
    public int getLeft() {
        return getWrappedObject().getLeft();
    }

    @Reflection.Setter
    public void setRight(int right) {
        getWrappedObject().setRight(right);
    }

    @Reflection.Getter
    public int getRight() {
        return getWrappedObject().getRight();
    }

    @Reflection.Setter
    public void setRotation(float rotation) {
        getWrappedObject().setRotation(rotation);
    }

    @Reflection.Getter
    public float getRotation() {
        return getWrappedObject().getRotation();
    }

    public interface WrappedInterface {
        int getVerticalFadingEdgeLength();
        void setFadingEdgeLength(int length);
        int getHorizontalFadingEdgeLength();
        int getVerticalScrollbarWidth();
        boolean showContextMenu();
        boolean hasFocus();
        boolean hasFocusable();
        View findFocus();
        boolean isFocused();
        boolean isShown();
        void requestFitSystemWindows();
        void setFocusable(boolean focusable);
        void setFocusableInTouchMode(boolean focusableInTouchMode);
        boolean hasTransientState();
        void setHasTransientState(boolean hasTransientState);
        void setWillNotDraw(boolean willNotDraw);
        boolean willNotDraw();
        void setWillNotCacheDrawing(boolean willNotCacheDrawing);
        boolean willNotCacheDrawing();
        View focusSearch(int direction);
        boolean dispatchUnhandledMove(View focused, int direction);
        ArrayList<View> getFocusables(int direction);
        void addFocusables(ArrayList<View> views, int direction);
        void addFocusables(ArrayList<View> views, int direction, int focusableMode);
        void findViewsWithText(ArrayList<View> outViews, CharSequence searched, int flags);
        ArrayList<View> getTouchables();
        void addTouchables(ArrayList<View> views);
        boolean requestFocus();
        boolean requestFocus(int direction);
        boolean requestFocusFromTouch();
        void setPadding(int left, int top, int right, int bottom);
        void setBackgroundColor(int color);
        void setBackgroundResource(int resid);
        View getRootView();

        @Reflection.Property int verticalScrollbarPosition();
        @Reflection.Property CharSequence contentDescription();
        @Reflection.Property boolean scrollContainer();
        @Reflection.Property int drawingCacheQuality();
        @Reflection.Property boolean keepScreenOn();
        @Reflection.Property int nextFocusLeftId();
        @Reflection.Property int nextFocusRightId();
        @Reflection.Property int nextFocusUpId();
        @Reflection.Property int nextFocusDownId();
        @Reflection.Property int nextFocusForwardId();
        @Reflection.Property boolean fitsSystemWindows();
        @Reflection.Property int visibility();
        @Reflection.Property boolean enabled();
        @Reflection.Property boolean soundEffectsEnabled();
        @Reflection.Property boolean hapticFeedbackEnabled();
        @Reflection.Property boolean clickable();
        @Reflection.Property boolean longClickable();
        @Reflection.Property boolean pressed();
        @Reflection.Property boolean saveEnabled();
        @Reflection.Property boolean filterTouchesWhenObscured();
        @Reflection.Property boolean saveFromParentEnabled();
        @Reflection.Property int importantForAccessibility();
        @Reflection.Property float alpha();
        @Reflection.Property boolean selected();
        @Reflection.Property boolean activated();
    }
}