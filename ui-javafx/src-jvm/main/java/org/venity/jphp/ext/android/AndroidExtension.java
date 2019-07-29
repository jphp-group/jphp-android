package org.venity.jphp.ext.android;

import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.DeviceService;
import com.gluonhq.charm.down.plugins.LocalNotificationsService;
import com.gluonhq.charm.down.plugins.Notification;
import com.gluonhq.charm.down.plugins.StorageService;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.application.StatusBar;
import com.gluonhq.charm.glisten.control.*;
import com.gluonhq.charm.glisten.layout.layer.SidePopupView;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.gluonhq.charm.glisten.visual.Swatch;
import javafx.animation.*;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.web.*;
import javafx.stage.*;
import netscape.javascript.JSException;
import org.venity.jphp.ext.android.android.classes.*;
import org.venity.jphp.ext.android.android.classes.services.PDeviceService;
import org.venity.jphp.ext.android.android.classes.services.PNotificationService;
import org.venity.jphp.ext.android.android.classes.services.PStorageService;
import org.venity.jphp.ext.android.android.classes.services.notifications.PNotification;
import org.venity.jphp.ext.android.android.classes.support.PView;
import org.venity.jphp.ext.android.fx.bind.*;
import org.venity.jphp.ext.android.fx.classes.*;
import org.venity.jphp.ext.android.fx.classes.animation.*;
import org.venity.jphp.ext.android.fx.classes.data.CustomNode;
import org.venity.jphp.ext.android.fx.classes.data.Data;
import org.venity.jphp.ext.android.fx.classes.effect.*;
import org.venity.jphp.ext.android.fx.classes.event.*;
import org.venity.jphp.ext.android.fx.classes.layout.*;
import org.venity.jphp.ext.android.fx.classes.paint.UXColor;
import org.venity.jphp.ext.android.fx.classes.shape.*;
import org.venity.jphp.ext.android.fx.classes.text.UXFont;
import org.venity.jphp.ext.android.fx.support.EventProvider;
import org.venity.jphp.ext.android.fx.support.ImageViewEx;
import org.venity.jphp.ext.android.fx.support.KeyboardManager;
import org.venity.jphp.ext.android.fx.support.control.*;
import org.venity.jphp.ext.android.fx.support.effect.EffectPipeline;
import org.venity.jphp.ext.android.fx.support.event.*;
import org.venity.jphp.ext.android.fx.support.tray.notification.TrayNotification;
import php.runtime.env.CompileScope;
import php.runtime.ext.support.Extension;
import php.runtime.memory.support.MemoryOperation;

public class AndroidExtension extends Extension {
    public static final String NS_FX = "php\\gui";
    public static final String NS_ANDROID = "php\\android";
    public static final String NS_ANDROID_SERVICE = "php\\android\\services";

    @Override
    public Status getStatus() {
        return Status.BETA;
    }

    @Override
    public String getName()
    {
        return "JavaFXPorts";
    }

    @Override
    public String getVersion() {
        return "1.0";
    }

    @Override
    public String[] getPackageNames() {
        return new String[] {
                "gui", "android"
        };
    }

    @Override
    public void onRegister(CompileScope scope)
    {
        registerFX(scope);
    }

    private void registerFX(CompileScope scope) {
        registerMemoryOperation(KeyCombinationMemoryOperation.class);
        registerMemoryOperation(CursorMemoryOperation.class);
        registerMemoryOperation(InsetsMemoryOperation.class);
        registerMemoryOperation(DurationMemoryOperation.class);
        registerMemoryOperation(ImageMemoryOperation.class);
        registerMemoryOperation(Rectangle2DMemoryOperation.class);
        registerMemoryOperation(BoundsMemoryOperation.class);
        registerMemoryOperation(IndexRangeMemoryOperation.class);

        registerClass(scope, UXGeometry.class);

        registerWrapperClass(scope, ObservableValue.class, UXValue.class);
        registerWrapperClass(scope, ObservableList.class, UXList.class);
        registerWrapperClass(scope, Application.class, UXApplication.class);
        registerWrapperClass(scope, MobileApplication.class, UXMobileApplication.class);
        registerWrapperClass(scope, Screen.class, UXScreen.class);

        registerWrapperClass(scope, Font.class, UXFont.class);
        registerWrapperClass(scope, Color.class, UXColor.class);
        registerWrapperClass(scope, Image.class, UXImage.class);

        registerWrapperClass(scope, Window.class, UXWindow.class);
        registerWrapperClass(scope, Stage.class, UXForm.class);
        registerWrapperClass(scope, PopupWindow.class, UXPopupWindow.class);
        registerWrapperClass(scope, Tooltip.class, UXTooltip.class);
        registerWrapperClass(scope, ContextMenu.class, UXContextMenu.class);
        registerWrapperClass(scope, MenuItem.class, UXMenuItem.class);
        registerWrapperClass(scope, Menu.class, UXMenu.class);
        registerWrapperClass(scope, Scene.class, UXScene.class);
        registerWrapperClass(scope, ExceptionDialog.class, UXExceptionDialog.class);

        registerWrapperClass(scope, View.class, UXView.class);

        registerWrapperClass(scope, Node.class, UXNode.class);
        registerWrapperClass(scope, Parent.class, UXParent.class);
        registerWrapperClass(scope, Region.class, UXRegion.class);
        registerWrapperClass(scope, Control.class, UXControl.class);
        registerWrapperClass(scope, Swatch.class, UXSwatch.class);

        registerWrapperClass(scope, Group.class, UXGroup.class);
        registerWrapperClass(scope, Pane.class, UXPane.class);
        registerWrapperClass(scope, AnchorPane.class, UXAnchorPane.class);
        registerWrapperClass(scope, Panel.class, UXPanel.class);
        registerWrapperClass(scope, StackPane.class, UXStackPane.class);
        registerWrapperClass(scope, VBox.class, UXVBox.class);
        registerWrapperClass(scope, FragmentPane.class, UXFragmentPane.class);
        registerWrapperClass(scope, HBox.class, UXHBox.class);
        registerWrapperClass(scope, FlowPane.class, UXFlowPane.class);
        registerWrapperClass(scope, TilePane.class, UXTilePane.class);
        registerWrapperClass(scope, BorderPane.class, UXBorderPane.class);

        registerWrapperClass(scope, Labeled.class, UXLabeled.class);
        registerWrapperClass(scope, ButtonBase.class, UXButtonBase.class);
        registerWrapperClass(scope, Button.class, UXButton.class);
        registerWrapperClass(scope, MenuButton.class, UXMenuButton.class);
        registerWrapperClass(scope, SplitMenuButton.class, UXSplitMenuButton.class);
        registerWrapperClass(scope, FlatButton.class, UXFlatButton.class);
        registerWrapperClass(scope, ToggleGroup.class, UXToggleGroup.class);
        registerWrapperClass(scope, ToggleButton.class, UXToggleButton.class);
        registerWrapperClass(scope, CheckBox.class, UXCheckbox.class);
        registerWrapperClass(scope, ImageView.class, UXImageView.class);
        registerWrapperClass(scope, ImageViewEx.class, UXImageArea.class);
        registerWrapperClass(scope, MenuBar.class, UXMenuBar.class);
        registerWrapperClass(scope, StatusBar.class, UXStatusBar.class);
        registerWrapperClass(scope, TextInputControl.class, UXTextInputControl.class);
        registerWrapperClass(scope, TextArea.class, UXTextArea.class);
        registerWrapperClass(scope, TextField.class, UXTextField.class);
        registerWrapperClass(scope, MaskTextField.class, UXMaskTextField.class);
        registerWrapperClass(scope, PasswordField.class, UXPasswordField.class);
        registerWrapperClass(scope, Spinner.class, UXSpinner.class);
        registerWrapperClass(scope, NumberSpinner.class, UXNumberSpinner.class);
        registerWrapperClass(scope, Label.class, UXLabel.class);
        registerWrapperClass(scope, LabelEx.class, UXLabelEx.class);
        registerWrapperClass(scope, Hyperlink.class, UXHyperlink.class);
        registerWrapperClass(scope, ComboBoxBase.class, UXComboBoxBase.class);
        registerWrapperClass(scope, ComboBox.class, UXComboBox.class);
        registerWrapperClass(scope, ChoiceBox.class, UXChoiceBox.class);
        registerWrapperClass(scope, ColorPicker.class, UXColorPicker.class);
        registerWrapperClass(scope, ProgressIndicator.class, UXProgressIndicator.class);
        registerWrapperClass(scope, ProgressBar.class, UXProgressBar.class);
        registerWrapperClass(scope, HTMLEditor.class, UXHtmlEditor.class);
        registerWrapperClass(scope, WebHistory.class, UXWebHistory.class);
        registerWrapperClass(scope, WebEngine.class, UXWebEngine.class);
        registerWrapperClass(scope, WebView.class, UXWebView.class);
        registerWrapperClass(scope, Tab.class, UXTab.class);
        registerWrapperClass(scope, DraggableTab.class, UXDraggableTab.class);
        registerWrapperClass(scope, TabPane.class, UXTabPane.class);
        MemoryOperation.registerWrapper(TabPaneEx.class, UXTabPane.class);
        registerWrapperClass(scope, ScrollPane.class, UXScrollPane.class);
        registerWrapperClass(scope, TitledPane.class, UXTitledPane.class);
        registerWrapperClass(scope, BottomNavigation.class, UXBottomNavigation.class);
        registerWrapperClass(scope, BottomNavigationButton.class, UXBottomNavigationButton.class);
        registerWrapperClass(scope, SplitPane.class, UXSplitPane.class);
        registerWrapperClass(scope, TreeItem.class, UXTreeItem.class);
        registerWrapperClass(scope, TreeView.class, UXTreeView.class);
        registerWrapperClass(scope, Toast.class, UXToast.class);
        registerWrapperClass(scope, Rating.class, UXRating.class);
        registerWrapperClass(scope, Separator.class, UXSeparator.class);
        registerWrapperClass(scope, com.gluonhq.charm.glisten.control.Alert.class, UXAndroidAlert.class);
        registerWrapperClass(scope, MaterialDesignIcon.class, UXMaterialIcons.class);
        registerWrapperClass(scope, ListView.class, UXListView.class);
        registerWrapperClass(scope, AppBar.class, UXAppBar.class);
        registerWrapperClass(scope, com.gluonhq.charm.glisten.control.Dialog.class, UXAndroidDialog.class);
        MemoryOperation.registerWrapper(ListViewEx.class, UXListView.class);
        registerWrapperClass(scope, FileChooser.class, UXFileChooser.class);
        registerWrapperClass(scope, NavigationDrawer.class, UXNavigationDrawer.class);
        registerWrapperClass(scope, SidePopupView.class, UXSidePopupView.class);
        registerWrapperClass(scope, DirectoryChooser.class, UXDirectoryChooser.class);
        registerWrapperClass(scope, Slider.class, UXSlider.class);
        registerWrapperClass(scope, DatePicker.class, UXDatePicker.class);
        registerWrapperClass(scope, Canvas.class, UXCanvas.class);
        MemoryOperation.registerWrapper(CanvasEx.class, UXCanvas.class);

        registerWrapperClass(scope, Cell.class, UXCell.class);
        registerWrapperClass(scope, TableView.class, UXTableView.class);
        registerWrapperClass(scope, TableColumnBase.class, UXTableColumn.class);
        registerWrapperClass(scope, TableCell.class, UXTableCell.class);
        registerWrapperClass(scope, ListCell.class, UXListCell.class);
        MemoryOperation.registerWrapper(TableColumn.class, UXTableColumn.class);
        MemoryOperation.registerWrapper(IndexedCell.class, UXCell.class);

        registerWrapperClass(scope, PaginationEx.class, UXPagination.class);

        registerWrapperClass(scope, Dragboard.class, UXDragboard.class);

        registerWrapperClass(scope, Shape.class, UXShape.class);
        registerWrapperClass(scope, Circle.class, UXCircle.class);
        registerWrapperClass(scope, Ellipse.class, UXEllipse.class);
        registerWrapperClass(scope, javafx.scene.shape.Polygon.class, UXPolygon.class);
        registerWrapperClass(scope, Rectangle.class, UXRectangle.class);

        MemoryOperation.registerWrapper(ActionEvent.class, UXEvent.class);
        MemoryOperation.registerWrapper(InputMethodEvent.class, UXEvent.class);
        MemoryOperation.registerWrapper(TreeView.EditEvent.class, UXEvent.class);
        MemoryOperation.registerWrapper(ListView.EditEvent.class, UXEvent.class);
        MemoryOperation.registerWrapper(TreeTableView.EditEvent.class, UXEvent.class);
        registerWrapperClass(scope, Event.class, UXEvent.class);

        registerWrapperClass(scope, MouseEvent.class, UXMouseEvent.class);
        registerWrapperClass(scope, MouseDragEvent.class, UXMouseEvent.class);
        registerWrapperClass(scope, KeyEvent.class, UXKeyEvent.class);
        registerWrapperClass(scope, WindowEvent.class, UXWindowEvent.class);
        registerWrapperClass(scope, ContextMenuEvent.class, UXContextMenuEvent.class);
        registerWrapperClass(scope, DragEvent.class, UXDragEvent.class);
        registerWrapperClass(scope, WebEvent.class, UXWebEvent.class);
        registerWrapperClass(scope, ScrollEvent.class, UXScrollEvent.class);

        registerWrapperClass(scope, FXMLLoader.class, UXLoader.class);
        registerWrapperClass(scope, Data.class, UXData.class);
        registerWrapperClass(scope, CustomNode.class, UXCustomNode.class);
        registerWrapperClass(scope, Alert.class, UXAlert.class);
        registerWrapperClass(scope, TrayNotification.class, UXTrayNotification.class);

        registerWrapperClass(scope, Media.class, UXMedia.class);
        registerWrapperClass(scope, MediaPlayer.class, UXMediaPlayer.class);
        registerWrapperClass(scope, MediaView.class, UXMediaView.class);
        registerWrapperClass(scope, MediaViewBox.class, UXMediaViewBox.class);

        registerWrapperClass(scope, GraphicsContext.class, UXGraphicsContext.class);

        registerClass(scope, UXDialog.class);
        registerClass(scope, UXClipboard.class);

        registerWrapperClass(scope, StorageService.class, PStorageService.class);
        registerWrapperClass(scope, DeviceService.class,  PDeviceService.class);
        registerWrapperClass(scope, LocalNotificationsService.class, PNotificationService.class);

        registerWrapperClass(scope, Notification.class, PNotification.class);

        registerJavaException(scope, WrapJSException.class, JSException.class);

        registerCustomControls(scope);
        registerEffectPackage(scope);
        registerAnimationPackage(scope);

        registerEvents(scope);
    }

    private void registerCustomControls(CompileScope scope) {
        registerWrapperClass(scope, RadioGroupPane.class, UXRadioGroupPane.class);
    }

    private void registerEffectPackage(CompileScope scope) {
        registerWrapperClass(scope, Effect.class, UXEffect.class);
        registerWrapperClass(scope, EffectPipeline.class, UXEffectPipeline.class);
        registerWrapperClass(scope, DropShadow.class, UXDropShadowEffect.class);
        registerWrapperClass(scope, InnerShadow.class, UXInnerShadowEffect.class);
        registerWrapperClass(scope, Reflection.class, UXReflectionEffect.class);
        registerWrapperClass(scope, Bloom.class, UXBloomEffect.class);
        registerWrapperClass(scope, Lighting.class, UXLightingEffect.class);
        registerWrapperClass(scope, GaussianBlur.class, UXGaussianBlurEffect.class);
        registerWrapperClass(scope, ColorAdjust.class, UXColorAdjustEffect.class);
        registerWrapperClass(scope, Glow.class, UXGlowEffect.class);
        registerWrapperClass(scope, SepiaTone.class, UXSepiaToneEffect.class);
    }

    private void registerAnimationPackage(CompileScope scope) {
        registerWrapperClass(scope, KeyFrame.class, UXKeyFrame.class);
        registerWrapperClass(scope, Animation.class, UXAnimation.class);
        registerWrapperClass(scope, Timeline.class, UXTimeline.class);
        registerWrapperClass(scope, FadeTransition.class, UXFadeAnimation.class);
        registerWrapperClass(scope, PathTransition.class, UXPathAnimation.class);

        registerWrapperClass(scope, AnimationTimer.class, UXAnimationTimer.class);
    }

    public static boolean isJigsaw() {
        String property = System.getProperty("java.version");
        return !property.startsWith("1.");
    }

    private void registerEvents(CompileScope scope) {
        registerEventProvider(new NodeEventProvider());
        registerEventProvider(new WindowEventProvider());
        registerEventProvider(new ContextMenuEventProvider());
        registerEventProvider(new MenuItemEventProvider());
        registerEventProvider(new MenuEventProvider());
        registerEventProvider(new ButtonBaseEventProvider());
        registerEventProvider(new MenuButtonEventProvider());
        registerEventProvider(new ComboBoxBaseEventProvider());
        registerEventProvider(new ChoiceBoxEventProvider());
        registerEventProvider(new WebEngineEventProvider());
        registerEventProvider(new TreeViewEventProvider());
        registerEventProvider(new TabEventProvider());
        registerEventProvider(new TabPaneEventProvider());
        registerEventProvider(new ListViewEventProvider());
        registerEventProvider(new RadioGroupPaneEventProvider());

        registerEventProvider(new AnimationEventProvider());
        registerEventProvider(new TrayNotificationEventProvider());

        registerWrapperClass(scope, KeyboardManager.class, UXKeyboardManager.class);
    }

    private void registerEventProvider(EventProvider eventProvider) {
        EventProvider.register(eventProvider);
    }
}
