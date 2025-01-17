package org.vaadin.gatanaso.demo;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.vaadin.gatanaso.MultiselectComboBox;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.provider.Query;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.router.Route;

@Route("")
public class DemoView extends VerticalLayout {

    public DemoView() {
        setSpacing(true);
        setMargin(true);

        addTitle();
        addSingleSelectStringDemo();
        addSimpleStringDemo();
        addObjectDemo();
        addObjectDemoWithLabelGenerator();
        addRequiredDemo();
        addCompactModeDemo();
        addCompactModeLabelGeneratorDemo();
        addOrderedDemo();
        addLazyLoadingDemo();
        addClearButtonVisibleDemo();
        addAllowCustomValuesDemo();
        addTemplateRendererDemo();
        addComponentRendererDemo();
    }

    private void addTitle() {
        Label title = new Label("Multiselect Combo Box Demos");
        add(title);
        setHorizontalComponentAlignment(Alignment.CENTER, title);
    }

    private void addSingleSelectStringDemo() {
        MultiselectComboBox<String> multiselectComboBox = new MultiselectComboBox();
        multiselectComboBox.addThemeName("whatever");
        multiselectComboBox.setLabel("MultiselectComboBox with string items in single select mode");
        multiselectComboBox.setPlaceholder("Add");
        multiselectComboBox.setWidth("100%");
        multiselectComboBox.setItems("Item 1", "Item 2", "Item 3", "Item 4");
        multiselectComboBox.setSingleSelectMode(true);
        multiselectComboBox.addSelectionListener(
                event -> Notification.show(event.toString()));

        Button getValueBtn = new Button("Get value");
        getValueBtn.addClickListener(
                event -> multiselectComboBoxValueChangeHandler(
                        multiselectComboBox));

        add(buildDemoContainer(multiselectComboBox, getValueBtn));
    }

    private void addSimpleStringDemo() {
        MultiselectComboBox<String> multiselectComboBox = new MultiselectComboBox();
        multiselectComboBox.setLabel("MultiselectComboBox with string items");
        multiselectComboBox.setPlaceholder("Add");
        multiselectComboBox.setWidth("100%");
        multiselectComboBox.setItems("Item 1", "Item 2", "Item 3", "Item 4");
        multiselectComboBox.addSelectionListener(
                event -> Notification.show(event.toString()));

        Button getValueBtn = new Button("Get value");
        getValueBtn.addClickListener(
                event -> multiselectComboBoxValueChangeHandler(
                        multiselectComboBox));

        add(buildDemoContainer(multiselectComboBox, getValueBtn));
    }

    private void addObjectDemo() {
        MultiselectComboBox<User> multiselectComboBox = new MultiselectComboBox();
        multiselectComboBox.setLabel("MultiselectComboBox with object items");
        multiselectComboBox.setPlaceholder("Add");
        multiselectComboBox.setWidth("100%");
        List<User> data = Arrays.asList(
                new User("Leanne Graham", "leanne", "leanne@demo.dev"),
                new User("Ervin Howell", "ervin", "ervin@demo.dev"),
                new User("Samantha Doe", "samantha", "samantha@demo.dev"));
        multiselectComboBox.setItems(data);
        multiselectComboBox.addSelectionListener(
                event -> Notification.show(event.toString()));

        Button getValueBtn = new Button("Get value");
        getValueBtn.addClickListener(
                event -> objectMultiselectComboBoxValueChangeHandler(
                        multiselectComboBox));

        add(buildDemoContainer(multiselectComboBox, getValueBtn));
    }

    private void addObjectDemoWithLabelGenerator() {
        MultiselectComboBox<User> multiselectComboBox = new MultiselectComboBox();
        multiselectComboBox.setLabel("MultiselectComboBox with object items and custom item label generator");
        multiselectComboBox.setPlaceholder("Add");
        multiselectComboBox.setWidth("100%");
        List<User> data = Arrays.asList(
                new User("Leanne Graham", "leanne", "leanne@demo.dev"),
                new User("Ervin Howell", "ervin", "ervin@demo.dev"),
                new User("Samantha Doe", "samantha", "samantha@demo.dev"));
        multiselectComboBox.setItems(data);
        multiselectComboBox.setItemLabelGenerator(User::getEmail);
        multiselectComboBox.addSelectionListener(
                event -> Notification.show(event.toString()));

        Button getValueBtn = new Button("Get value");
        getValueBtn.addClickListener(
                event -> objectMultiselectComboBoxValueChangeHandler(
                        multiselectComboBox));

        add(buildDemoContainer(multiselectComboBox, getValueBtn));
    }

    private void addRequiredDemo() {
        MultiselectComboBox<String> multiselectComboBox = new MultiselectComboBox();
        multiselectComboBox.setLabel("Required MultiselectComboBox");
        multiselectComboBox.setPlaceholder("Add");
        multiselectComboBox.setWidth("100%");
        multiselectComboBox.setRequired(true);
        multiselectComboBox.setErrorMessage("The field is mandatory");
        multiselectComboBox.setItems("Item 1", "Item 2", "Item 3", "Item 4");
        multiselectComboBox.addSelectionListener(
                event -> Notification.show(event.toString()));

        Button getValueBtn = new Button("Get value");
        getValueBtn.addClickListener(
                event -> multiselectComboBoxValueChangeHandler(
                        multiselectComboBox));

        add(buildDemoContainer(multiselectComboBox, getValueBtn));
    }

    private void addCompactModeDemo() {
        MultiselectComboBox<String> multiselectComboBox = new MultiselectComboBox();
        multiselectComboBox.setLabel("MultiselectComboBox in compact mode");
        multiselectComboBox.setPlaceholder("Add");
        multiselectComboBox.setWidth("100%");
        multiselectComboBox.setItems("Item 1", "Item 2", "Item 3", "Item 4");
        multiselectComboBox.addSelectionListener(
                event -> Notification.show(event.toString()));

        multiselectComboBox.setCompactMode(true);

        Button getValueBtn = new Button("Get value");
        getValueBtn.addClickListener(
                event -> multiselectComboBoxValueChangeHandler(
                        multiselectComboBox));

        add(buildDemoContainer(multiselectComboBox, getValueBtn));
    }

    private void addCompactModeLabelGeneratorDemo() {
        MultiselectComboBox<String> multiselectComboBox = new MultiselectComboBox();
        multiselectComboBox.setLabel("MultiselectComboBox with compact mode label generator");
        multiselectComboBox.setPlaceholder("Add");
        multiselectComboBox.setWidth("100%");
        multiselectComboBox.setItems("Item 1", "Item 2", "Item 3", "Item 4");
        multiselectComboBox.addSelectionListener(
            event -> Notification.show(event.toString()));

        multiselectComboBox.setCompactMode(true);
        multiselectComboBox.setCompactModeLabelGenerator((items) -> {
            if (items.size() == 0) {
                return "Choose items...";
            } else if (items.size() == 1) {
                return "One item selected";
            } else {
                return items.size() + " Items selected";
            }
        });

        Button getValueBtn = new Button("Get value");
        getValueBtn.addClickListener(
            event -> multiselectComboBoxValueChangeHandler(
                multiselectComboBox));

        add(buildDemoContainer(multiselectComboBox, getValueBtn));
    }

    private void addOrderedDemo() {
        MultiselectComboBox<String> multiselectComboBox = new MultiselectComboBox();
        multiselectComboBox.setLabel("MultiselectComboBox with ordered selected items list");
        multiselectComboBox.setPlaceholder("Add");
        multiselectComboBox.setWidth("100%");
        multiselectComboBox.setItems("Item 1", "Item 2", "Item 3", "Item 4");
        multiselectComboBox.addSelectionListener(
                event -> Notification.show(event.toString()));

        multiselectComboBox.setOrdered(true);

        Button getValueBtn = new Button("Get value");
        getValueBtn.addClickListener(
                event -> multiselectComboBoxValueChangeHandler(
                        multiselectComboBox));

        add(buildDemoContainer(multiselectComboBox, getValueBtn));
    }

    private void addLazyLoadingDemo() {
        MultiselectComboBox<String> multiselectComboBox = new MultiselectComboBox();
        multiselectComboBox.setLabel("MultiselectComboBox with lazy loading");
        multiselectComboBox.setPlaceholder("Add");
        multiselectComboBox.setWidth("100%");

        List<String> items =IntStream.range(1, 10000).mapToObj(num -> "Item " + num).collect(Collectors.toList());
        multiselectComboBox.setItems(items);

        multiselectComboBox.addSelectionListener(
                event -> Notification.show(event.toString()));

        Button getValueBtn = new Button("Get value");
        getValueBtn.addClickListener(
                event -> multiselectComboBoxValueChangeHandler(
                        multiselectComboBox));

        add(buildDemoContainer(multiselectComboBox, getValueBtn));
    }

    private void addClearButtonVisibleDemo() {
        MultiselectComboBox<String> multiselectComboBox = new MultiselectComboBox();
        multiselectComboBox.setLabel("MultiselectComboBox with `clear-button-visible`");
        multiselectComboBox.setPlaceholder("Add");
        multiselectComboBox.setWidth("100%");
        multiselectComboBox.setItems("Item 1", "Item 2", "Item 3", "Item 4");
        multiselectComboBox.addSelectionListener(
                event -> Notification.show(event.toString()));

        multiselectComboBox.setClearButtonVisible(true);

        Button getValueBtn = new Button("Get value");
        getValueBtn.addClickListener(
                event -> multiselectComboBoxValueChangeHandler(
                        multiselectComboBox));

        add(buildDemoContainer(multiselectComboBox, getValueBtn));
    }

    private void addAllowCustomValuesDemo() {
        MultiselectComboBox<String> multiselectComboBox = new MultiselectComboBox();
        multiselectComboBox.setLabel("MultiselectComboBox which allows custom values");
        multiselectComboBox.setPlaceholder("Select existing or input custom value");
        multiselectComboBox.setWidth("100%");
        List<String> items = Arrays.asList("Java", "Go", "Python", "C#");
        multiselectComboBox.setItems(items);

        multiselectComboBox.addCustomValuesSetListener(e -> {
            Set<String> existingSelected = multiselectComboBox.getValue().stream().collect(Collectors.toSet());
            existingSelected.add(e.getDetail());
            List<String> updatedItems = multiselectComboBox.getDataProvider().fetch(new Query<>()).collect(Collectors.toList());
            updatedItems.add(e.getDetail());
            multiselectComboBox.setItems(updatedItems);
            multiselectComboBox.setValue(existingSelected);
        });

        Button getValueBtn = new Button("Get value");
        getValueBtn.addClickListener(
            event -> multiselectComboBoxValueChangeHandler(
                multiselectComboBox));

        add(buildDemoContainer(multiselectComboBox, getValueBtn));
    }

    public void addTemplateRendererDemo() {
        MultiselectComboBox<User> multiselectComboBox = new MultiselectComboBox();
        multiselectComboBox.setLabel("MultiselectComboBox with TemplateRenderer");
        multiselectComboBox.setPlaceholder("Add");
        multiselectComboBox.setWidth("100%");
        List<User> data = Arrays.asList(
            new User("Leanne Graham", "leanne", "leanne@demo.dev"),
            new User("Ervin Howell", "ervin", "ervin@demo.dev"),
            new User("Samantha Doe", "samantha", "samantha@demo.dev"));
        multiselectComboBox.setItems(data);
        multiselectComboBox.setItemLabelGenerator(User::getEmail);
        multiselectComboBox.addSelectionListener(
            event -> Notification.show(event.toString()));

        Button getValueBtn = new Button("Get value");
        getValueBtn.addClickListener(
            event -> objectMultiselectComboBoxValueChangeHandler(
                multiselectComboBox));

        multiselectComboBox.setRenderer(
            TemplateRenderer.<User>of("<div>[[item.username]]<br/><small>[[item.email]]</small><br/><small>[[item.name]]<small></div>")
                .withProperty("name", User::getName)
                .withProperty("email", User::getEmail)
                .withProperty("username", User::getUsername));

        add(buildDemoContainer(multiselectComboBox, getValueBtn));
    }

    public void addComponentRendererDemo() {
        MultiselectComboBox<User> multiselectComboBox = new MultiselectComboBox();
        multiselectComboBox.setLabel("MultiselectComboBox with ComponentRenderer");
        multiselectComboBox.setPlaceholder("Add");
        multiselectComboBox.setWidth("100%");
        List<User> data = Arrays.asList(
            new User("Leanne Graham", "leanne", "leanne@demo.dev"),
            new User("Ervin Howell", "ervin", "ervin@demo.dev"),
            new User("Samantha Doe", "samantha", "samantha@demo.dev"));
        multiselectComboBox.setItems(data);
        multiselectComboBox.setItemLabelGenerator(User::getEmail);
        multiselectComboBox.addSelectionListener(
            event -> Notification.show(event.toString()));

        Button getValueBtn = new Button("Get value");
        getValueBtn.addClickListener(
            event -> objectMultiselectComboBoxValueChangeHandler(
                multiselectComboBox));

        multiselectComboBox.setRenderer(new ComponentRenderer<VerticalLayout, User>(VerticalLayout::new, (container, user) -> {
            HorizontalLayout name = new HorizontalLayout(new Icon(VaadinIcon.USER), new Label(user.getName()));
            HorizontalLayout email = new HorizontalLayout(new Icon(VaadinIcon.SUITCASE), new Label(user.getEmail()));
            container.add(name, email);
        }));

        add(buildDemoContainer(multiselectComboBox, getValueBtn));
    }

    private void multiselectComboBoxValueChangeHandler(
            MultiselectComboBox<String> multiselectComboBox) {
        Set<String> selectedItems = multiselectComboBox.getValue();
        String value = selectedItems.stream().collect(Collectors.joining(", "));
        Notification.show("Items value: " + value);
    }

    private void objectMultiselectComboBoxValueChangeHandler(
            MultiselectComboBox<User> multiselectComboBox) {
        Set<User> selectedItems = multiselectComboBox.getValue();
        String value = selectedItems.stream().map(User::toString)
                .collect(Collectors.joining(", "));
        Notification.show("Users value: " + value);
    }

    private VerticalLayout buildDemoContainer(
            MultiselectComboBox multiselectComboBox, Button... actions) {
        VerticalLayout demoContainer = new VerticalLayout();
        demoContainer.getStyle().set("background-color", "#fcfcfc");
        demoContainer.getStyle().set("box-shadow", "1px 1px 1px 1px #ccc");
        demoContainer.setSpacing(true);
        demoContainer.setMargin(true);
        demoContainer.setWidth("600px");
        setHorizontalComponentAlignment(Alignment.CENTER, demoContainer);
        demoContainer.add(multiselectComboBox);
        for (Button action : actions) {
            demoContainer.add(action);
        }
        return demoContainer;
    }

    /**
     * Example demo object class.
     */
    class User {
        private String name;
        private String username;
        private String email;

        public User(String name, String username, String email) {
            this.name = name;
            this.username = username;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
