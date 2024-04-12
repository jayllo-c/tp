---
layout: default.md
title: "Developer Guide"
---

# Avengers Assemble Developer Guide

<!-- * Table of Contents -->
## Table of Contents

<div id="table-of-contents" style="line-height: 2.0">
<ol>
    <li><a href="#acknowledgements">Acknowledgements</a></li>
    <li><a href="#setting-up">Setting Up, Getting Started</a></li>
    <li><a href="#design">Design</a>
        <ol>
            <li><a href="#Architecture">Architecture</a></li>
            <li><a href="#ui-component">UI Component</a></li>
            <li><a href="#logic-component">Logic Component</a></li>
            <li><a href="#model-component">Model Component</a></li>
            <li><a href="#storage-component">Storage Component</a></li>
            <li><a href="#common-classes">Common Classes</a></li>
        </ol>
    </li>
    <li><a href="#implementation">Implementation</a>
        <ol>
            <li><a href="#general-features">General Features</a>
                <ol>
                    <li><a href="#help">Help Command</a></li>
                    <li><a href="#clear">Clear Command</a></li>
                    <li><a href="#list">List Command</a></li>
                </ol>
            <li><a href="#contact-management">Contact Management Features</a>
                <ol>
                    <li><a href="#add-person">Add Person Command</a></li>
                    <li><a href="#edit-person">Edit Person Command</a></li>
                    <li><a href="#delete-person">Delete Person Command</a></li>
                    <li><a href="#find">Find Command</a></li>
                    <li><a href="#deleteshown">Delete Shown Command</a></li>
                    <li><a href="#import">Import Contacts Command</a></li>
                    <li><a href="#copy">Copy Command</a></li>
                    <li><a href="#export">Export Command</a></li>
                    <li><a href="#optional-fields">Feature: Addition of Optional Fields (Matric)</a></li>
                    <li><a href="#tagging">Feature: Automatic Tagging of Persons</a></li>
                </ol>
            </li>
            <li><a href="#exam-management">Exam Features</a>
                <ol>
                    <li><a href="#addexam">Add Exam Command</a></li>
                    <li><a href="#deleteexam">Delete Exam Command</a></li>
                    <li><a href="#exam-modification-diagram">Sequence Diagrams Illustrating Exam Modification</a></li>
                    <li><a href="#exam-selection">Select Exam Command</a></li>
                    <li><a href="#exam-deselection">Deselect Exam Command</a></li>
                    <li><a href="#exam-selection-diagram">Sequence Diagrams Illustrating Exam Selection</a></li>
                    <li><a href="#exam-considerations">Considerations for Exam Features</a></li>
                </ol>
            </li>
            <li><a href="#score-management">Exam Score Features</a>
                <ol>
                    <li><a href="#addscore">Add Score Command</a></li>
                    <li><a href="#editscore">Edit Score Command</a></li>
                    <li><a href="#deletescore">Delete Score Command</a></li>
                    <li><a href="#importexamscores">Import Exam Scores Command</a></li>
                    <li><a href="#scorestatistics">Score Statistics Feature</a></li>
                </ol>
            </li>
        </ol>
    </li>
    <li><a href="#planned-enhancements">Planned Enhancements</a></li>
    <li><a href="#documentation">Documentation, Logging, Testing, Configuration, Dev-ops</a></li>
    <li><a href="#appendix">Appendix</a>
        <ol>
            <li><a href="#appendix_a">Appendix A: Product Scope</a></li>
            <li><a href="#appendix_b">Appendix B: User Stories</a></li>
            <li><a href="#appendix_c">Appendix C: Use Cases</a></li>
            <li><a href="#appendix_d">Appendix D: Non-Functional Requirements</a></li>
            <li><a href="#appendix_e">Appendix E: Glossary</a></li>
            <li><a href="#appendix_f">Appendix F: Instructions for Manual Testing</a></li>
                <ol>
                    <li><a href="#test_launch">Launch and Shutdown</a></li>
                    <li><a href="#test_save">Saving Data</a></li>
                    <li><a href="#test_help">Getting Help</a></li>
                    <li><a href="#test_clear">Clearing all Persons and Exams: <code>clear</code></a></li>
                    <li><a href="#test_import">Importing persons: <code>import</code></a></li>
                    <li><a href="#test_add">Adding a Person: <code>add</code></a></li>
                    <li><a href="#test_edit">Editing a Person: <code>edit</code></a></li>
                    <li><a href="#test_delete">Deleting a Person: <code>delete</code></a></li>
                    <li><a href="#test_deleteshown">Deleting shown Persons: <code>deleteShown</code></a></li>
                    <li><a href="#test_list">Listing all Persons: <code>list</code></a></li>
                    <li><a href="#test_find">Finding a Person: <code>find</code></a></li>
                    <li><a href="#test_copy">Copying Emails: <code>copy</code></a></li>
                    <li><a href="#test_export">Exporting Data to a CSV File: <code>export</code></a></li>
                    <li><a href="#test_addexam">Adding an Exam: <code>addExam</code></a></li>
                    <li><a href="#test_deleteexam">Deleting an Exam: <code>deleteExam</code></a></li>
                    <li><a href="#test_selectexam">Selecting an Exam: <code>selectExam</code></a></li>
                    <li><a href="#test_deselectexam">Deselecting an Exam: <code>deselectExam</code></a></li>
                    <li><a href="#test_importexam">Importing Exam Scores: <code>importExamScores</code></a></li>
                    <li><a href="#test_addscore">Adding a Persons's Exam Score: <code>addScore</code></a></li>
                    <li><a href="#test_editscore">Editing a Person's Exam Score: <code>editScore</code></a></li>
                    <li><a href="#test_deletescore">Deleting a Person's Exam Score: <code>deleteScore</code></a></li>
                    <li><a href="#test_statistics">Mean and Median of Exam Scores</a></li>
                </ol>
            <li><a href="#appendix_g">Appendix G: Effort</a></li>
        </ol>
    </li>



--------------------------------------------------------------------------------------------------------------------
<div id="acknowledgements"></div>

## **Acknowledgements**

This project is based on the AddressBook-Level3 project created by the [SE-EDU initiative](https://se-education.org).

Features related to the creation and reading of CSV files were made possible through the use of the [OpenCSV](http://opencsv.sourceforge.net/) library.

Our project made use of AI assistance from [GitHub Copilot](https://copilot.github.com/) to finish small snippets of code and to provide suggestions.

--------------------------------------------------------------------------------------------------------------------

<div id="setting-up"></div>

## **Setting Up, Getting Started**

Refer to the guide [_Setting up and getting started_](SettingUp.md).

--------------------------------------------------------------------------------------------------------------------

<div id="design"></div>

## **Design**

<div id="Architecture"></div>

### Architecture

<p align="center"><puml src="diagrams/ArchitectureDiagram.puml" width="280" /></p>

The ***Architecture Diagram*** given above explains the high-level design of the App.

Given below is a quick overview of main components and how they interact with each other.

**Main components of the architecture**

**`Main`** (consisting of classes [`Main`](https://github.com/AY2324S2-CS2103T-T10-1/tp/tree/master/src/main/java/seedu/address/Main.java) and [`MainApp`](https://github.com/AY2324S2-CS2103T-T10-1/tp/tree/master/src/main/java/seedu/address/MainApp.java)) is in charge of the app launch and shut down.
* At app launch, it initializes the other components in the correct sequence, and connects them up with each other.
* At shut down, it shuts down the other components and invokes cleanup methods where necessary.

The bulk of the app's work is done by the following four components:

* [**`UI`**](#ui-component): The UI of the App.
* [**`Logic`**](#logic-component): The command executor.
* [**`Model`**](#model-component): Holds the data of the App in memory.
* [**`Storage`**](#storage-component): Reads data from, and writes data to, the hard disk.

[**`Commons`**](#common-classes) represents a collection of classes used by multiple other components.

**How the architecture components interact with each other**

The *Sequence Diagram* below shows how the components interact with each other for the scenario where the user issues the command `delete 1`.

<p align="center"><puml src="diagrams/ArchitectureSequenceDiagram.puml" width="574" /></p>

Each of the four main components (also shown in the diagram above),

* defines its *API* in an `interface` with the same name as the Component.
* implements its functionality using a concrete `{Component Name}Manager` class (which follows the corresponding API `interface` mentioned in the previous point.)

For example, the `Logic` component defines its API in the `Logic.java` interface and implements its functionality using the `LogicManager.java` class which follows the `Logic` interface. Other components interact with a given component through its interface rather than the concrete class (reason: to prevent outside component's being coupled to the implementation of a component), as illustrated in the (partial) class diagram below.

<p align="center"><puml src="diagrams/ComponentManagers.puml" width="300" /></p>

The sections below give more details of each component.

<br>

<div id="ui-component"></div>

### UI Component

The **API** of this component is specified in [`Ui.java`](https://github.com/AY2324S2-CS2103T-T10-1/tp/tree/master/src/main/java/seedu/address/ui/Ui.java)

<p align="center"><puml src="diagrams/UiClassDiagram.puml" alt="Structure of the UI Component"/></p>

The UI consists of a `MainWindow` that is made up of parts e.g.`CommandBox`, `ResultDisplay`, `PersonListPanel`, `StatusBarFooter` etc. All these, including the `MainWindow`, inherit from the abstract `UiPart` class which captures the commonalities between classes that represent parts of the visible GUI.

The `UI` component uses the JavaFx UI framework. The layout of these UI parts are defined in matching `.fxml` files that are in the `src/main/resources/view` folder. For example, the layout of the [`MainWindow`](https://github.com/AY2324S2-CS2103T-T10-1/tp/tree/master/src/main/java/seedu/address/ui/MainWindow.java) is specified in [`MainWindow.fxml`](https://github.com/AY2324S2-CS2103T-T10-1/tp/tree/master/src/main/resources/view/MainWindow.fxml)

The `CommandBox` takes in user input which is passed onto the `Logic` component for the user input to be parsed and executed. A `CommandResult` is returned after execution and the feedback is displayed to the user through the `ResultDisplay` component of the UI.

For the updating of other components in the UI, after each command execution, `MainWindow` runs an update that calls the update method on `PersonListPanel`, `ExamListPanel` and `StatusBarFooter`.

`PersonListPanel` and `ExamListPanel` update themselves by retrieving the `filteredPersonList` and `examList` from the `Model` component and updating the displayed lists accordingly.

`StatusBarFooter` contains the mean and median feature, and it updates itself by retrieving `ScoreStatistics`
from the `Model` on update.

In summary, the `UI` component:

* executes user commands using the `Logic` component.
* checks for changes to `Model` data so that the UI can be updated with the modified data.
* keeps a reference to the `Logic` component, because the `UI` relies on the `Logic` to execute commands.
* depends on some classes in the `Model` component, as the `UI` updates based on items that are stored in `Model`

The sequence diagram below illustrates a more in-depth view of the interactions within the UI component

<p align="center"><puml src="diagrams/UiSequenceDiagram.puml" alt="Sequence Diagram of UI Component"/></p>

#### Considerations For UI

##### Dynamic UI Updates

The UI is designed to update dynamically based on changes in the `Model`. We narrowed down to two design choices for updating the UI components. They are:

1. **Update using listeners embeded into UI components** - This design choice would involve embedding listeners into the UI components that would listen for changes in the `Model` (e.g. adding a listener to filteredPersons in ExamListPanel). This would allow for a more loosely coupled system, but would involve more complex implementation which could get messy as the number of listeners increase.
2. **Update using a centralized update method** - This design choice involves having a centralized `update` method in the `MainWindow` that would call an `update` method in all other UI components after every command. This would involve a more tightly coupled system and may involve unnecessary updates, but would be easier to implement and maintain.

We chose the second design choice as having a centralized update method would allow for easier maintenance, as there is a clear indicator of how UI components are updated from `MainWindow`. Adding extensions would also be more straightforward as future developers would know where to look for the update logic.

With listeners, the update logic would be scattered across multiple UI component classes, making it much harder to search and add upon the update logic.

One of our main goals was to make our codebase easy to understand and maintain, and we felt that the centralized update method would be more in line with this goal despite the slight increase in coupling and inefficiency.

<br>

<div id="logic-component"></div>

### Logic Component

**API** : [`Logic.java`](https://github.com/AY2324S2-CS2103T-T10-1/tp/tree/master/src/main/java/seedu/address/logic/Logic.java)

Here's a (partial) class diagram of the `Logic` component:

<p align="center"><puml src="diagrams/LogicClassDiagram.puml" width="550"/></p>

How the `Logic` component works:

1. When `Logic` is called upon to execute a command, it is passed to an `AddressBookParser` object which in turn creates a parser that matches the command (e.g., `DeleteCommandParser`) and uses it to parse the command.
2. This results in a `Command` object (more precisely, an object of one of its subclasses e.g., `DeleteCommand`) which is executed by the `LogicManager`.
3. The command can communicate with the `Model` when it is executed (e.g. to delete a person).<br>
   Note that although this is shown as a single step in the diagram above (for simplicity), in the code it can take several interactions (between the command object and the `Model`) to achieve.
4. The result of the command execution is encapsulated as a `CommandResult` object which is returned back from `Logic`.

Here are the other classes in `Logic` (omitted from the class diagram above) that are used for parsing a user command:

<p align="center"><puml src="diagrams/ParserClasses.puml" width="600"/></p>

How the parsing works:

* When called upon to parse a user command, the `AddressBookParser` class creates an `XYZCommandParser` (`XYZ` is a placeholder for the specific command name e.g., `AddCommandParser`)
* The `XYZCommandParser` [uses the other classes](#specificParsing) shown above to parse the user command and create a `XYZCommand` object (e.g., `AddCommand`) which the `AddressBookParser` returns back as a `Command` object.
* All `XYZCommandParser` classes (e.g., `AddCommandParser`, `DeleteCommandParser`, ...) inherit from the `Parser` interface so that they can be treated similarly where possible e.g, during testing.

<br>

#### Example of Parsing User Input: `delete` Command

The sequence diagram below illustrates the interactions within the `Logic` component, taking a simple `execute("delete 1")` API call as an example.

<p align="center"><puml src="diagrams/DeleteSequenceDiagram.puml" alt="Interactions Inside the Logic Component for the `delete 1` Command" /></p>

**Note:** The lifeline for `DeleteCommandParser` should end at the destroy marker (X) but due to a limitation of PlantUML, the lifeline continues till the end of diagram.
</box>

The following is a more detailed explaination on how user input is parsed into a `Command` object (Not mentioned above for simplicity).

* After the `XYZCommandParser` is instantiated by the `AddressBookParser`, it uses the `ArgumentTokenizer` class to tokenize the user input string into the arguments.
* It then uses the `ArgumentMultimap` class to extract the arguments based on the prefixes present in the user input string.
* For some commands, some arguments are mandatory and the `ArgumentMultimap` class is used to check if these mandatory arguments are present. If not, an exception is thrown.
* For some commands, multiple arguments under the same category (e.g. two name arguments for an AddCommand) are not allowed. The `ArgumentMultimap` class is used to check for undesirable multiple arguments. If multiple arguments are present, an exception is thrown.
* Validation of each extracted argument is done using the methods defined in the `ParserUtil` class. This class contains methods to validate different arguments extracted by the `ArgumentMultimap` class based on the `VALIDATION_REGEX` defined in component classes (`Name.java`, `Score.java`, etc.).
* The parsed arguments are then used to create a `XYZCommand` object to be executed.

**Note:** Some commands do not require any arguments (e.g., `help`, `clear`, `list`, `exit`). In such cases, the `XYZCommand` class is directly instantiated by the `AddressBookParser` class without the parsing of arguments. As such, any arguments passed to these commands are ignored.

#### Considerations for Logic

The `Logic` component is designed to be the central component that executes all user commands. This design choice was made to ensure that all commands are executed in a consistent manner, and to prevent the duplication of command execution logic across different components. By centralizing the command execution logic in the `Logic` component, we ensure that all commands are executed in the same way, regardless of the component that initiates the command execution. This design choice also allows for easier maintenance and extensibility, as any changes to the command execution logic can be made in a single location.

<br>

<div id="model-component"></div>

### Model Component
**API** : [`Model.java`](https://github.com/AY2324S2-CS2103T-T10-1/tp/master/src/main/java/seedu/address/model/Model.java)

<p align="center"><puml src="diagrams/ModelClassDiagram.puml" width="450" /></p>


The `Model` component,

* stores the address book data i.e., all `Person` objects (which are contained in a `UniquePersonList` object) and all `Exam` objects (which are contained in a `UniqueExamList` object).
* stores the currently filtered `Person` objects (e.g., results of a search query) as a separate _filtered_ list which is exposed to outsiders as an unmodifiable `ObservableList<Person>` that can be 'observed' e.g. the UI can be bound to this list so that the UI can update when the data in the list changes.
* stores the currently selected `Exam` which is exposed to outsiders as an unmodifiable `ObservableValue<Exam>`. This is used in conjunction with the exam and exam score implementation, and also used to update the highlighted exam on the UI.
* stores `ScoreStatistics` for the currently selected `Exam`. This statistic is used in conjunction with the mean and median feature. It is also exposed to outsiders as an unmodifiable `ObservableValue<ScoreStatistics>` so that the UI can be bound to this value for updating.
* stores a `UserPref` object that represents the user’s preferences. This is exposed to the outside as a `ReadOnlyUserPref` objects.
* does not depend on any of the other three components (as the `Model` represents data entities of the domain, they should make sense on their own without depending on other components)

<box type="info" seamless>

**Note:** An alternative (arguably, a more OOP) model is given below relating to the `Person` class. It has a `Tag` list in the `AddressBook`, which `Person` references. This allows `AddressBook` to only require one `Tag` object per unique tag, instead of each `Person` needing their own `Tag` objects.<br> However, we opted not to use this model. As much as possible, we tried to keep the attributes of `Person` unlinked to other classes to prevent complications in our saving, import and export functionalities.

<p align="center"><puml src="diagrams/BetterModelClassDiagram.puml" width="450" /></p>

</box>

<br>

<div id="storage-component"></div>

### Storage Component

**API** : [`Storage.java`](https://github.com/AY2324S2-CS2103T-T10-1/tp/tree/master/src/main/java/seedu/address/storage/Storage.java)

<p align="center"><puml src="diagrams/StorageClassDiagram.puml" width="550" /></p>

<br>
<br>

#### Saving of Data

The `Storage` component uses the `Jackson` library to convert objects to JSON format. The conversion methods are predefined in the `JsonAdapted*` classes for their corresponding objects.

The `Logic` class stores a `StorageManager` object that implements the methods in the `Storage` class. For **every** command that is executed, `Logic` uses `StorageManager` to save the updated `AddressBook` through the `saveAddressBook` method.

The `StorageManager` class calls on the `JsonAddressBookStorage` class to convert all objects in the `AddressBook` to JSON formatting. The converted JSON objects are consolidated in the `JsonSerializableAddressBook` class and it is seraliazed to JSON format and saved using the `saveJsonToFile` method.

The sequence diagram below illustrates how data is saved within the `Storage` component when the user issues a command.

<p align="center"><puml src="diagrams/StorageSequenceDiagram.puml" alt="Sequence Diagram for the `Storage` Component" /></p>

<br>
<br>

#### Loading of Data

When the application is initialised, the `Storage` component reads the JSON objects from the save file and converts them back to objects that can be used to initialise the `Model` component. This is done using the `readJsonFile` method of the `JsonUtil` class which utilises the methods defined in the `JsonAdapted*` classes to convert the saved JSON data back to objects that can be used by the `Model` component.

The sequence diagram below illustrates how data is loaded within the `Storage` component when the application is initialised.

<p align="center"><puml src="diagrams/StorageLoadSequenceDiagram.puml" alt="Sequence Diagram for the `Storage` Component" /></p>


In summary, the `Storage` component:
* can save both address book data and user preference data in JSON format, and read them back into corresponding objects.
* inherits from both `AddressBookStorage` and `UserPrefStorage`, which means it can be treated as either one (if only the functionality of only one is needed).
* depends on some classes in the `Model` component (because the `Storage` component's job is to save/retrieve objects that belong to the `Model`)

<br>

### Common Classes

Classes used by multiple components are in the `seedu.addressbook.commons` package.
These classes provide utility functions that are used across different components such as
`CollectionUtil`, `StringUtil`, `JsonUtil` etc. It also contains app wide constants and exceptions.

--------------------------------------------------------------------------------------------------------------------

<div id="implementation"></div>

## **Implementation**

This section describes some noteworthy details on how certain features are implemented

<div id="general features"></div>

### General Features

As these general features do not require any arguments, the `AddressBookParser` directly instantiates the corresponding command classes.

<div id ="help"></div>

#### **Help Command** : `help`

The `help` command utilizes the `java.awt.Toolkit` class to copy the user guide link to the user's clipboard.

##### Executing the Command

On execution of the `HelpCommand`, the `copyToClipboard` method is called which retrives the system clipboard
through `Toolkit.getDefaultToolkit().getSystemClipboard()` and copies the user guide link to the clipboard by using
`setContents` method.

##### Design Considerations

We designed the help command to copy the user guide link directly to the clipboard as we wanted our application to be
CLI optimised. This allows our target users to easily access the user guide without having to use their mouse
to navigate to the user guide link.

<div id="clear"></div>

#### **Clear Command** : `clear`

The `clear` command allows users to clear all persons and exams from the address book.

##### Executing the Command

The `ClearCommand` simply sets the `AddressBook` in the `Model` component to a new `AddressBook` object, effectively clearing all persons and exams from the address book.

##### Design Considerations

We designed the `clear` command to clear all persons and exams from the address book to provide users with a quick and easy way to reset the address book to its initial state. This is useful for users who want to start over or clear the address book for a fresh start.

<div id="list"></div>

#### **List Command** : `list`

The `list` command allows users to list all persons in the address book.

##### Executing the Command

The `ListCommand` retrieves the `filteredPersonList` from the `Model` component and returns a `CommandResult` object containing the list of persons to be displayed on the UI.

##### Design Considerations

We designed the `list` command to list all persons in the address book to provide users with a quick and easy way to view all persons in the address book. This is useful to revert the UI back to the default view after a find command has been executed which filters the persons displayed on the UI.

<div id="contact-management"></div>

### Contact Management Features

All contacts are stored as `Person` objects in the `UniquePersonList` object under the `AddressBook` of the `Model` component.
There is an additional `filteredPersons` list stored in the `Model` component that stores the persons currently displayed in the `PersonListPanel` on the UI. This list is updated whenever the user issues a command that might change the persons displayed in the `PersonListPanel`.

<div id="add-person"></div>

#### **Add Person Command** : `add`

The `add` command allows users to add a person to the address book.

The user can specify the person's:
* name (`Name`),
* phone number (`Phone`),
* address (`Address`),
* email (`Email`),

and optionally provide additional information such as their:
* matriculation number (`Matric`),
* reflection (`Reflection`),
* studio (`Studio`),
* and tags (`Tag`).

<br>

##### Parsing User Input
The `AddCommandParser` class is responsible for parsing user input to extract the details of the person to be added. It uses the `ArgumentTokenizer` to tokenize the input string, extracting prefixes and their associated values. It ensures that all mandatory fields are present and that there are no duplicate prefixes in the user input.

##### Executing the Command
The `AddCommand` class creates a new `Person` object with the parsed details.
The `Person` object is then added to the `UniquePersonList` through the `addPerson` method in the `Model` component.

##### Sequence Diagram

The sequence diagram below illustrates a more in-depth view of the interactions regarding the parsing of user input.
It takes an add command: `execute(add n|Dohn Joe p|98765432 a|123 e|dohn@gm.com m|A1234567X s|S1 r|R1)` as an example.

<p align="center"><puml src="diagrams/AddSequenceDiagram.puml" alt="Detailed Interactions Inside the Logic Component for the `add n/Dohn Joe p/98765432 a/123 e/dohn@gm.com m/A1234567X s/S1 r/R1` User Input" /></p>

<box type="info" seamless>

**Note:** The lifeline for `AddCommandParser` should end at the destroy marker (X) but due to a limitation of PlantUML, the lifeline continues till the end of diagram.
</box>

The parsing is detailed as follows:
<p align="center"><puml src="diagrams/AddCommandParsing.puml" alt="Detailed Interactions for Parsing Fields of the Add command." /></p>

<br>
<br>

##### Design Considerations

**Use of `Email` Field as Unique Identifier** <br>

We have chosen to use the `Email` field as a unique identifier. Due to the real-world implementation of email addresses, and specifically in NUS, email addresses are unique to each person. This allows for easy identification of persons and prevents the creation of duplicate persons with the same email address.

This is opposed to using the `Name` field as a unique identifier, as an app with our proposed scale will likely be handling a large number of persons potentially having the same name. This would make it difficult to identify or keep track of persons with the same name.

**Compulsory and Non-compulsory Fields** <br>

We have chosen to make the following fields compulsory as they are essentials and most likely available to the head TA:
* `Name`
* `Email`
* `Phone`
* `Address`

The following fields are optional as they may not be available for all persons:
* `Matric`
* `Reflection`
* `Studio`
* `Tag`

<br>

<div id="edit-person"></div>

#### **Edit Person Command** : `edit`

The `edit` command allows a user to edit the details of an existing person.

##### Parsing User Input

The `EditCommandParser` class is responsible for parsing user input to extract the index of the person to be edited and the new details of the person.
It uses the `ArgumentTokenizer` class to tokenize the user input string, extracting the index of the person to be edited and the new details of the person. It ensures that the index is valid and that there are no duplicate prefixes in the user input.

##### Executing the Command

The `EditCommand` first retrieves the person to be edited from the `Model` component.
This is done by first retrieving the `filteredPersonList` from the `Model` component using the `getFilteredPersonList` method
The person to be edited is then retrived from the `filteredPersonList` using the index provided by the user.
The `EditCommand` then creates a new `Person` object with the new details provided by the user and the selected person's existing details. The `Person` object is then updated in the `UniquePersonList` through the `setPerson` method in the `Model` component.

##### Activity Diagram

The activity diagram below illustrates the workflow involved in executing the `edit` command. In practice, a `Reject` activity will result in a `CommandException` being thrown.

<p align="center"><puml src="diagrams/EditCommandActivityDiagram.puml" alt="Activity Diagram for the `edit` Command" /></p>

<br>

<div id="delete-person"></div>

#### **Delete Person Command** : `delete`

The `delete` command allows a user to delete a person with the specified index.

##### Parsing User Input

The `DeleteCommandParser` class is responsible for parsing user input to extract the index of the person to be deleted. It uses the `ArgumentTokenizer` to tokenize the input string, extracting the index of the person to be deleted and ensuring that the index is valid.

##### Executing the Command

The `DeleteCommand` class first retrieves the person to be deleted from the `Model` component. This is done by first retrieving the `filteredPersonList` from the `Model` component using the `getFilteredPersonList` method. The person to be deleted is then retrieved from the `filteredPersonList` using the index provided by the user. The `DeleteCommand` then deletes the person from the `UniquePersonList` through the `deletePerson` method in the `Model` component.

##### Sequence Diagram

For more details on the implementation of the `delete` command, refer to the [Delete Command Sequence Diagram](#example-of-parsing-user-input-delete-command).

##### Design Considerations

We have chosen to implement the `delete` command to accept the index of the person to be deleted to maximize convenience for the user. The numbering of the lists will be displayed to the user, making indexing very intuitive.

<br>

<div id="find"></div>

#### **Find Command** : `find`

The `find` command lets users search for persons by substring matching. The user can select any parameter to search under:
`NAME`, `EMAIL`, `TAG`, `MATRIC`, `REFLECTION`, `STUDIO`, and `TAGS` can all be used. E.g. to search for all persons under studio `S2`, the user can use `find s|s2`.

The user can also use two other prefixes: `lt` and `mt` to search for persons with scores less than or more than a certain value respectively.
E.g. `find mt|50` will return all persons with scores more than 50.

The `find` feature makes use of the predicate classes `PersonDetailPredicate` and `ExamPredicate`, as well as the method `updateFilteredPersonList`
to update the model to show only persons that fulfill the criteria that the user has keyed in.

##### Parsing User Input

The `FindCommandParser` class is responsible for parsing user input to extract search criteria. It uses the `ArgumentTokenizer` to tokenize the input string,
extracting prefixes and their associated values. Next, the method `verifyNoDuplicatePrefixesFor` ensures that there are no duplicate prefixes in the user input.
Following that, the `extractPrefixForFindCommand` method ensures that only one valid, non-empty prefix is provided in the input.
After which, the `extractValidKeyword` method ensures that the keyword provided in the input is valid in the case that the prefix is `mt|` or `lt|`,
since these two prefixes specifically require a numerical value as the keyword instead of a string value.

##### Executing the Command

The `FindCommand` class is responsible for executing the command for filtering the list in the application.

Using the prefix and keyword from parsing user input, a `FindCommand` is created. the `execute` method is then called by the `LogicManager`.

**Creating Predicate** <br>

<box type="info" seamless>

**Note:** The `PersonDetailPredicate` and `ExamPredicate` classes implement the `Predicate` interface to filter contacts based on the search criteria.
A brief overview of the two classes is given below:
* `PersonDetailPredicate` takes a prefix and keyword as parameters, allowing it to filter contacts based on specific details like name, phone number, etc.
* `ExamPredicate` takes a prefix, a keyword, and an exam as parameters, allowing it to filter contacts based on exam scores of a specific exam.
</box>


The find command first checks if an exam is required by checking if the prefix is `mt|` or `lt|`.
If an exam is required, the `selectedExam` is retrieved from the `model` and passed to the `ExamPredicate` constructor along with the prefix and keyword.
Otherwise, the `PersonDetailPredicate` class is created with the prefix and keyword.

**Updating Filtered Person List** <br>

The `ModelManager` class implements the `Model` interface and manages the application's data. It maintains a `filteredPersons` list,
which is a filtered list of contacts based on the applied predicate. The `updateFilteredPersonList` method implemented in `ModelManager`
updates the filtered list based on the predicate provided.

When the `FindCommand` is executed, the `updateFilteredPersonList` method is called with either the `PersonDetailPredicate` or `ExamPredicate` as a parameter.
This updates the `filteredPersons` list to show only persons that fufill the conditions set in the `test` method in either of the predicates.

**User Interface Interaction** <br>

After the `filteredPersons` list is updated, the user interface is updated such that the `PersonListPanel` now shows persons that fufill the predicate generated by the original user input.

The following sequence diagram illustrates the `find` command with the user input `find n|Alice`.
<p align="center"><puml src="diagrams/FindImplementationSequenceDiagram.puml" width="1000" /></p>

The next sequence diagram details the creation of the predicate, as well as the updating of the `filteredPersons` list in the `Model` component.
<p align="center"><puml src="diagrams/FindImplementationPredicateCreationSequenceDiagram.puml" width="700" /></p>

The following activity Diagram illustrates the user execution of the `find` command.
<p align="center"><puml src="diagrams/FindImplementationActivityDiagram.puml" width="800" /></p>

The next activity diagram is an expansion of the previous diagram, detailing the case where the user searches for contacts based on exam scores.
<p align="center"><puml src="diagrams/FindImplementationFindByScoreActivityDiagram.puml" width="1000" /></p>

##### Design Considerations

**User Interface Consistency** <br>

The choice of implementing the command to use prefixes to determine the filter criteria ensures consistency with other commands in the application.
As this command follows a similar structure to all other commands, it is easier for users to learn and use the application.

**Flexibility in Search Criteria** <br>

By allowing users to specify search criteria using different prefixes (name, phone, email, etc.), the implementation offers flexibility.
Users can search for contacts based on various details, enhancing the usability of the feature.

In the context of our potential users,
we considered that users would likely have to sometimes filter students by their classes, or filter people by their roles (student, tutor, professor).
So we opted to implement this feature with the flexibility of using all prefixes to account for all these potential use cases.

Furthermore, with consideration that our potential users will interact with exam scores, we wanted to integrate the find functionality
to search for contacts based on exam scores. Hence, we decided to introduce the `mt|` and `lt|` prefixes to allow users to search for contacts based on exam scores.

**Two Predicate Classes** <br>

The implementation of two predicate classes, `PersonDetailPredicate` and `ExamPredicate`, allows for a clear separation of concerns.

The `PersonDetailPredicate` class is responsible for filtering contacts based on details like name, phone number, etc.,
while the `ExamPredicate` class is responsible for filtering contacts based on exam scores.

The alternative would be to have a single predicate class that handles all filtering, but this would make this supposed class more complex and harder to maintain.

**Predicate-based Filtering** <br>

As the `Model` class was built prior to the implementation of this feature, we did our best to re-use available methods
instead of unnecessarily reprogramming already existing logic. Hence, we decided to craft the command around the idea of a
custom predicate as the `Model` class already had a `updateFilteredPersonList` method implemented that would filter persons using a predicate.

**Extensibility** <br>

This design allows for easy extension to accommodate future enhancements or additional search criteria.
New prefixes can be added to support additional search criteria without significant changes as we merely need to update our `Predicate` logic.
This ensures that the implementation remains adaptable to evolving requirements and we can upgrade and improve the feature whenever required.

<br>

<div id="deleteshown" ></div>

#### **Delete Shown Command** : `deleteShown`

The `deleteShown` command relies on the `filteredPersons` list in the `Model` component to delete the persons currently displayed in the `PersonListPanel`.

##### Executing the Command

The `deleteShown` command first retrives the `filteredPersons` list from the `Model` component using the `getFilteredPersonList` method. The `deleteShown` command then iterates through the `filteredPersons` list and deletes all currently shown `Persons` from the `UniquePersonList`.

If the currently filtered list does is not showing between 0 and the total number of existing persons, the `deleteShown` command will throw a `CommandException`.

##### Updating Filtered Person List

After deleting all persons currently displayed in the `PersonListPanel`, the `filteredPersons` list in the `Model` component is updated to show all remaining persons in the address book.

The following activity diagram illustrates the workflow of the execution of the `deleteShown` command:

<p align="center"><puml src="diagrams/DeleteShownActivityDiagram.puml" alt="Activity Diagram for the `deleteShown` Command" /></p>

##### Design Considerations

**Reliance on `find` Command** <br>

Similarly to the `copy` command, the `deleteShown` command is designed to be used with the find command, which filters the persons displayed in the `PersonListPanel`. Consequently, the flexibility of the `deleteShown` command relies heavily on the implementation of the `find` command. Due to this dependency, any changes to the `find` command may affect the functionality of the `deleteShown` command.

<br>

<div id="import"></div>

#### **Import Contacts Command** : `import`

The `import` command allows users to import contacts from a CSV file. Users can specify the file path of the CSV file to
import contacts from and with the validation and checking of the CSV rows, person objects can be added to the addressbook.

##### Parsing User Input

The `ImportCommandParser` class is responsible for parsing user input to extract the file path of the CSV file to be imported. It uses the `ArgumentTokenizer` to tokenize the input string, extracting the file path of the CSV file to be imported.

##### Executing the Command

The `ImportCommand` class first makes use `OpenCSV` library which parses the CSV file into a `List<String[]>`, with each `String[]`
representing a row in the CSV file. The `List<String[]>` is further parsed row by row by the `readCsvFile` method, which
returns a `Pair`. The key of the returned `Pair` is a `personsData` list containing the `Person` objects sucessfully parsed from the CSV file and the value is an error report containing all the errors that occured during the process of reading from the CSV file.

The `ImportCommand` then iterates through the `personsData` list and adds each `Person` object to the `Model` component
through repeated use of the `AddCommand`. Errors that occur during this process are also added to the error report.

In summary, The import process is done in the following steps:
1. ImportCommand reads the CSV file with the given file path.
2. The CSV file is parsed and each row is converted into an addCommand
3. The addCommand is then executed passing the same model as import command.
4. The addCommand then adds the person to the model.

**Handling duplicate persons** <br>

Duplicate records in the imported CSV file is handled by `AddCommand`, which will check if the person already exists in the model. If the person already exists, the `AddCommand` throws a `CommandException` which is caught by the `ImportCommand` and added to an error report.

**Handling invalid CSV files**<br>

Invalid files are handled by ImportCommand, with the help of ImportCommandParser and CsvUtil. ImportCommandParser will check if  is a CSV file.
CsvUtil will check if the CSV file is valid and will return a list of persons and an error report. The error report will be displayed to the user if there are any errors.

Overall, the conditions checked are:
- The file exists
- The file is a CSV file
- **The first row of the file is the header row**. In which all compulsory fields for creating a persons object
  (ie `name`, `email`, `address`, `phone`)are present. Optional headers will be read if present. Headers in the csv that are not a field in `Person` will be ignored.

If the file is not valid, an error message will be returned.

**Handling duplicate headers in the CSV file**

Handled by CsvUtil. The first occurrence of the header will be used and the rest will be ignored.

The sequence diagrams below illustrates the interactions within the `Logic` component when the user issues the command `import`.

**Parsing**

<p align="center"><puml src="diagrams/ImportParserSequenceDiagram.puml" alt="Interactions Inside the Logic Component for the `import` Command for parsing" /></p>

**Execution**

<p align="center"><puml src="diagrams/ImportSequenceDiagram.puml" alt="Interactions Inside the Logic Component for the `import` Command" /></p>

**Reference Diagram for each addCommand in importCommand**

<p align="center"><puml src="diagrams/ImportSequenceDiagramRef.puml" alt="Interactions Inside the Add Component for the `import` Command" /></p>

<br>
<br>

##### Design Considerations

**Usage of `AddCommand`** <br>

The main concern in the increased coupling between `ImportCommand` and `AddCommand`. However, we established that this coupling was actually a good thing, as the incoporation of the `AddCommand` allowed us to reuse the validation and error handling that was already implemented in the `AddCommand`. Furthermore, should we ever need to change the validation and error handling in the `AddCommand`, the `ImportCommand` would automatically inherit these changes. By making `AddCommand` the gate in which all persons are added to the model, we ensure that all persons added to the model are validated and handled in the same way.

<br>

<div id="copy"></div>

#### **Copy Command** : `copy`

The `copy` command enables users to quickly copy the email addresses of the persons currently displayed to them in the
`PersonListPanel`. The copied emails are stored in the users' clipboard and can be pasted into an email client.
This feature is useful when users need to send emails to a group of persons.

The copy command is a child of the `command` class and relies on the `filteredPersons` list in the `Model` component,
as well as the `java.awt` package to copy the emails of all currently displayed persons to the users' clipboard.

##### Parsing User Input

The `CopyCommand` class is instantiated directly by the `AddressBookParser` class when the user inputs the `copy` command.
This is because the `copy` command does not require any additional arguments from the user.

##### Executing the Command

The `CopyCommand` class is responsible for executing the command for obtaining the emails of the filtered persons and copying them to the clipboard.
It iterates through the `filteredPersons` list in the `Model` component and extracts the email addresses of each person.
The email addresses are then concatenated into a single string, separated by commas, and copied to the clipboard using the `java.awt` package.

**User Interface Interaction** <br>

After the `CopyCommand` is executed, the `UI` component updates the `ResultDisplay` to show a message indicating that the emails have been copied to the clipboard.

The following activity diagram summarizes the steps involved in executing the `copy` command:
<p align="center"><puml src="diagrams/CopyImplementationActivityDiagram.puml" width="1000" /></p>

##### Considerations

**Reliance on `find` Command** <br>

The `copy` command is designed to be used with the find command, which filters the persons displayed in the `PersonListPanel`.
Consequently, the flexibility of the `copy` command relies heavily on the implementation of the `find` command.
Due to this dependency, any changes to the `find` command may affect the functionality of the `copy` command.

##### Extensibility

Due to the simplicity of the `copy` command, there are limited opportunities for extending its functionality.
However, future enhancements could include the ability to copy other details of persons, such as phone numbers or addresses.

##### Alternative Implementations

**Alternative 1: Copying emails of all persons**

Copies the emails of all persons in the address book, regardless of whether they are currently displayed in the `PersonListPanel`.
However, this approach may lead to users copying a large number of emails unintentionally, which could be overwhelming.
Furthermore, it may not be clear to users which emails are being copied.

**Alternative 2: Copying emails into a file**

Instead of copying the emails to the clipboard, the emails could be saved into a file.
This approach would allow users to access the emails at a later time and would prevent the loss of copied emails if the clipboard is cleared.
However, it may be less convenient for users who want to paste the emails directly into an email client.

<br>

<div id="export"></div>

#### **Export Command** : `export`

The `export` command allows users to export the details of each person currently displayed in the `PersonListPanel` to a CSV file. The CSV file is generated in the file `./addressbookdata/avengersassemble.csv`.

The user can first use the `find` feature to filter out the relevant persons, which will be displayed in the `PersonListPanel`.
The `export` feature also relies on the Jackson Dataformat CSV module and the Jackson Databind module to write the details of persons to the CSV file `./addressbookdata/avengersassemble.csv`.

##### Parsing User Input

The `export` command does not require any additional arguments from the user. Hence, an `ExportCommandParser` class is not required.
`AddressBookParser` directly creates an `ExportCommand` object.

##### Executing the Command

**Data Retrieval** <br>
* The `execute` method retrieves the `filteredPersons` list in `Model` by calling the `getFilteredPersonList()` method in `Model`.
  This list stores the relevant persons currently displayed in the `PersonListPanel`.
  It then creates a temporary `AddressBook` object and iterates through the `filteredPersons` list to add each person from the list into the AddressBook.
  The data is then written to a JSON file named `filteredaddressbook.json` with the `writeToJsonFile` method in `ExportCommand`.

* The `execute` method also retrieves the address book file path by calling the `getAddressBookFilePath()` method in `Model` (this address book stores information of **all** persons and exams).
  This file path is retrieved to obtain information on the examinations added in the application

The sequence diagram illustrates the interactions between the Logic and Model components when data is being retrieved from `Model` when `export` is executed:

<p align="center">
    <puml src="diagrams/ExportDataRetrievalSequenceDiagram.puml" alt="Sequence Diagram for Parsing of addScore command" />
</p>

**JSON File Handling** <br>

The contents of both the JSON files retrieved in the above section is read with the `readJsonFile()` method in `ExportCommand` and returned as JSON trees, `filteredJsonTree` and `unfilteredJsonTree`.
This method uses Jackson's `ObjectMapper`.

* From the `filteredJsonTree`, the persons array is extracted using the `readPersonsArray()` method in `ExportCommand` to obtain the filtered persons and their data.
* From the `unfilteredJsonTree`, the exams array is extracted using the `readExamsArray()` method in `ExportCommand` to obtain the exams.

**CSV Conversion** <br>

A CSV file, `avengersassemble.csv`, to write the data to, is created.
Its directory is also created using the `createCsvDirectory()` method in `ExportCommand` if the directory does not exist.
The CSV schema is dynamically built based on the structure of the JSON array using the `buildCsvSchema()` method in `CsvUtil`. This method relies on the Jackson Dataformat CSV module to build the CSV schema.
The CSV schema and JSON data are used to write to the CSV file using Jackson's `CsvMapper`.

The following sequence diagram shows the interactions within the different classes in the JSON file handling section and CSV conversion section when the `export` command is executed:

<p align="center">
  <puml src="diagrams/ExportSequenceDiagram.puml" alt="Sequence Diagram for the `export` Command" />
</p>

<br>
<br>

##### Design Considerations

**Obtaining Exam Names from `exams` Array in the Address Book File Path**<br>
* **Alternative 1 (current choice):** Obtaining exam names from `exams` array in the address book file path.
  * A person in the JSON file will only contain the exam details if they have a score for that exam.
    Therefore, with this choice, if no one in the filtered person's JSON file contains any score for a specific exam, the exam name will still be exported.
  * By adopting this alternative, users will be informed about the existence of an exam even if none of the persons in the filtered list have a score for that exam.
<br><br>
* **Alternative 2:** Obtaining exam names directly from `persons` array in the filtered person's JSON file.
  * This choice will only export an exam if someone in the filtered persons list has a score for that exam.

<br>

**Adding `Exam:` to Exam Names in the CSV Column Headings**<br>
Since users have the flexibility to determine the names of exams added, there's a possibility of adding an exam with the same name as a field (e.g. `reflection`).
This could lead to confusion when mapping the CSV schema and JSON data.
Therefore, appending `Exam:` to the beginning of exam names in the CSV column headings can help mitigate this potential confusion.

<br>

<div id="optional-fields"></div>

#### **Feature: Addition of Optional Fields (Matric)**

The optional `Matric` field enables the user to store the matriculation number of a person. The field is stored as a `Matric` in the `Person` object.

Note: The optional `Studio` and `Reflection` fields are similarly implemented.

##### Implementation Details

The `Matric` class is a simple wrapper class that ensures it is valid according to NUS matriculation number format and is not empty.
The `Matric` field is used by the `add` and `edit` commands.

##### Parsing User Input: `add`

For the `add` command, as opposed to the `name` and other fields, the parser does not check if a prefix for `Matric` is present. This is because we define the `Matric` field to be optional as contacts (e.g. professors) do not need to have a matriculation number.

The parser also verifies that there are no duplicate prefixes for `Matric` in a single `add` command. A new Person is then created with the `Matric` field set to the parsed `Matric` object.

If there is no `Matric` field present, the `Matric` field of the new `Person` object is set to `null`.

##### Parsing User Input: `edit`

For the `edit` command, the parser will add or update the `Matric` field of the person being edited.

<br>

<div id="tagging"></div>

#### **Feature: Automatic Tagging of Persons**

A `student` tag is automatically added during the parsing of the `add` command based on the presence of the `Matric` field of the person being added.

##### Implementation Details

During the parsing of the `add` command, the parser will check if the `Matric` field is present, indicating that they are a student.
The parser also generates `Tag` objects based on the user input. The existing tags are updated with the new automatically generated tag.

The activity diagram is as follows:
<p align="center"><puml src="diagrams/AutomaticTaggingActivityDiagram.puml" alt="Activity Diagram for Auto Tagging Feature" /></p>

<br>

<div id="exam-management"></div>

--------------------------------------------------------------------------------------------------------------------

### **Exam Features**

There are 4 main commands that are used to interact with the exam feature: `addExam`, `deleteExam`, `selectExam` and `deselectExam`.

All exams are stored in the `UniqueExamList` object in `AddressBook` of the `Model` component. The `Model` component also stores the currently selected exam in the `selectedExam` field.

<br>

<div id="addexam"></div>

#### **Add Exam Command** : `addExam`

The `addExam` command allows users to add an exam to the application.
The user can specify the name of the exam and the maximum score of the exam.
The exam is then added and stored in the `UniqueExamList`.

##### Parsing User Input

The `AddExamCommandParser` is responsible for pasring user input to extract the `name` and the `maxScore` of the exam.
It uses the `ArgumentTokenizer` to tokenize the input string, extracting `name` and `maxScore`.
It ensures that `name` and `maxScore` are valid and present in the user input, and that there are no duplicate prefixes in the user input.
The `name` and `maxScore` are then used to instantiate an `AddExamCommand`.

##### Executing the Command

The `AddExamCommand` class creates a new `Exam` object with the parsed arguments
It adds the `Exam` to the `UniqueExamList` through the `addExam` method in the `Model` component.
If the exam already exists in the list, a `CommandException` is thrown.

<br>

<div id="deleteexam"></div>

#### **Delete Exam Command** : `deleteExam`

The `deleteExam` command allows users to delete an exam from the application.
The user can specify the index of the exam to be deleted.
The exam is then removed from the `UniqueExamList`.

##### Parsing User Input

The `DeleteExamParser` is responsible for parsing user input to extract the `index` of the exam to be deleted.
It uses the `ArgumentTokenizer` to tokenize the input string, extracting the `index`.
It ensures that the `index` is valid and present in the user input, and that there are no other prefixes in the user input.
The `index` is used to instantiate a `DeleteExamCommand`.

##### Executing the Command

The `DeleteExamCommand` uses the index to delete the exam from the `UniqueExamList` in the `Model` component.
It first retrieves the `UniqueExamList` by using the `getExamList` method in the `Model` component.
It then retrieves the exam from the `UniqueExamList` using the user provided index.
If the index is greater than the size of the list, a `CommandException` is thrown.
Using the retrieved exam, it then deletes the exam from the `UniqueExamList` through the `deleteExam` method in the `Model` component.

<br>

<div id="exam-modification-diagram"></div>

#### **Sequence Diagrams Illustrating Exam Modification**

The following two sequence diagram illustrates the interactions between the Logic and Model when an exam is modified. This diagram uses the `addExam` command as an example.

**Parsing**

<p align="center"><puml src="diagrams/AddExamParsingSequenceDiagram.puml" alt="Sequence Diagram for the parsing of `addExam` Command" /></p>

**Execution**

<p align="center"><puml src="diagrams/AddExamExecutionSequenceDiagram.puml" alt="Sequence Diagram for the execution of `addExam` Command" /></p>

Note: `deleteExam` follows a similar structure, differing in the arguments parsed and the methods called on the `Model` component (e.g. deleting from `UniqueExamList` instead of adding to it).

<br>

<div id="exam-selection"></div>

#### **Select Exam Command** : `selectExam`

The `selectExam` command allows users to select an exam from the ``UniqueExamList`.
The selection of exams is heavily used in conjunction with our exam score features.

##### Parsing User Input

The `SelectExamCommandParser` is responsible for parsing user input to extract the `index` of the exam to be selected.
It uses the `ArgumentTokenizer` to tokenize the input string, extracting the `index`.
It ensures that the `index` is valid and present in the user input, and that there are no other prefixes in the user input.

##### Executing the Command

The `SelectExamCommand` uses the index to select an exam from the `UniqueExamList` in the `Model` component.
It first retrieves the `UniqueExamList` by using the `getExamList` method in the `Model` component.
It then retrieves the exam from the `UniqueExamList` using the user provided index.
If the index is greater than the size of the list, a `CommandException` is thrown.
Using the retrieved exam, it then sets the `selectedExam` field in the `Model` component using the `selectExam` method.

<br>

<div id="exam-deselection"></div>

#### **Deselect Exam Command** : `deselectExam`

The `deselectExam` command allows users to deselect the currently selected exam.

##### Parsing User Input

The `deselectExam` command does not take any arguments from the user.
Hence, a `DeselectExamCommandParser` is not required. `AddressBookParser` directly creates a `DeselectExamCommand` object.

##### Executing the Command

The `DeselectExamCommand` uses the `deselectExam` method in the `Model` component to deselect the currently selected exam.
It sets the `selectedExam` field in the `Model` component to `null`.
If there is no exam selected, a `CommandException` is thrown.

<br>

<div id="exam-selection-diagram"></div>

#### **Sequence Diagrams Illustrating Exam Selection**

The following sequence diagram illustrates the interactions between the Logic and Model when the `SelectExamCommand` is executed.

<p align="center"><puml src="diagrams/SelectExamSequenceDiagram.puml" alt="Sequence Diagram for the parsing of `selectExam` Command" /></p>

Notes:
- The `ObservableList<Exam>` object is what is returned when retrieving the `UniqueExamList`. This prevents unwanted modifications to the `UniqueExamList` when retrieving the selected exam.
- `deselectExam` follows a similar structure as the diagram above, differing in the arguments parsed and the methods called on the `Model` component (i.e. calling `deselectExam` on `Model` instead of `selectExam`).

<br>

<div id="exam-considerations"></div>

#### **Considerations for Exam Features**

##### Using a Selection System for Exams

We decided to implement a selection system for exams to complement the exam score feature. The application would only display the scores of the selected exam, making it easier for users to manage and view the scores.

Our alternative design was to display the scores of all exams at once on every person. However, this alternative design would have made the UI cluttered and less user-friendly. The selection system allows users to focus on the scores of a specific exam, making it easier to view and manage the scores.

##### Using Index for Exam Selection
We were initially torn between the selection of exams using the exam name or the index. We eventually settled on using the index as it is easier for users to type and remember short numeric codes rather than potentially long and complex exam names which are more prone to typographical errors.

##### Allowing Deselection of Exams
We decided to allow users to deselect exams as the exam scores and score statistics are displayed based on the selected exam. Deselecting the exam allows users to get rid of the displayed scores and statistics when they are no longer needed.

##### Extensibility
The design of the exam feature allows for easy extension to accommodate future enhancements or additional functionalities. Methods for managing exams are implemented in the `Model` component, and the updating of UI for Exams is abstracted into the UI component, Making it easy to add new commands or features related to exams.

<br>

--------------------------------------------------------------------------------------------------------------------

<div id="score-management"></div>

### **Exam Score Features**

There are 3 main commands that are used to interact with exam scores of each person: `addScore`, `editScore` and `deleteScore`.

<br>

<div id="addscore"></div>

#### **Add Score Command** : `addScore`

The `addScore` command allows users to add a score for an exam to a person displayed in the application.
The user should select the exam they want to add a score for, then specify the index of the person they want to add a score for, and the score they want to add.
The score is then stored in a hashmap named `scores` within the `Person` object in the `Model` component.
This hashmap maps the selected exam (an `Exam` object) to the specified score (a `Score` object).

##### Parsing User Input

The `AddScoreCommandParser` is responsible for parsing the user input to extract the index of the person in the displayed list to add a score to, and the score to add.
It uses the `ArgumentTokenizer` to tokenize the input string, extracting the `index` and `score`.
It also ensures that the `index` and `score` input value is valid, and that there are no duplicate prefixes in the user input.
The `index` and `score` is then used in instantiating the `AddScoreCommand` by the `AddScoreCommandParser`.

The following sequence diagram illustrates the parsing of an `addScore` command with the user input `addScore 1 s|100`:

<p align="center">
    <puml src="diagrams/AddScoreParsingSequenceDiagram.puml" alt="Sequence Diagram for Parsing of addScore command" />
</p>

> **Note:** <br>
> The parsing of an `editScore` command follows a similar structure, differing in the object instantiated at the end of the `parse` method.
> `EditScoreCommandParser` instantiates an `EditScoreCommand` object.

##### Executing the Command

The `execute` method in `AddScoreCommand` retrieves the `filteredPersons` list in `Model`, and validates the target index against the list of filtered persons to ensure it is not out of bounds.
It then fetches the person to add the score for based on the target index.
It also retrieves the currently selected exam from the `Model`, and validates that the score to be added is not more than the maximum score of the selected exam.
It adds the score to the person's existing `scores` hashmap using the `addExamScoreToPerson` method in the `Model`.

The following sequence diagram illustrates the execution of an `addScore` command:

<p align="center">
    <puml src="diagrams/AddScoreExecutionSequenceDiagram.puml" alt="Sequence Diagram for Parsing of addScore command" />
</p>

> **Note:** <br>
> The execution of an `editScore` command follows a similar structure to the execution of an `addScore` command.

<br>

<div id="editscore"></div>

#### **Edit Score Command** : `editScore`

The `editScore` command allows users to edit a score for an exam of a person displayed in the application.
The user should select the exam they want to edit the score for, then specify the index of the person they want to edit the score for, and the new score they want to edit to.
The updated score is then stored in a hashmap named `scores` within the `Person` object in the `Model` component.
This hashmap maps the selected exam (an `Exam` object) to the updated specified score (a `Score` object).

##### Parsing User Input

The `EditScoreCommandParser` is responsible for parsing the user input to extract the index of the person in the displayed list to edit the score for, and the new score to edit to.
It uses the `ArgumentTokenizer` to tokenize the input string, extracting the `index` and `score`.
It also ensures that the `index` and `score` input value is valid, and that there are no duplicate prefixes in the user input.
The `index` and `score` is then used in instantiating the `EditScoreCommand` by the `EditScoreCommandParser`.

##### Executing the Command

The `execute` method in `EditScoreCommand` retrieves the `filteredPersons` list in `Model`, and validates the target index against the list of filtered persons to ensure it is not out of bounds.
It then fetches the person to edit the score for based on the target index.
It also retrieves the currently selected exam from the `Model`, and validates that the score to be added is not more than the maximum score of the selected exam.
It updates the score for the selected exam in the person's existing `scores` hashmap using the `addExamScoreToPerson` method in `Model`.

<br>

<div id="deletescore"></div>

#### **Delete Score Command** : `deleteScore`

The `deleteScore` command allows users to delete a score for an exam from a person displayed in the application.
The user should select the exam they want to delete the score for, then specify the index of the person they want to delete the score for.
The key-value pair (exam-score) is removed from the `scores` hashmap within the `Person` object.
This operation removes both the selected exam (key) and the score (value), effectively deleting the score from `Person`.

##### Parsing User Input

The `DeleteScoreCommandParser` is responsible for parsing the user input to extract the index of the person in the displayed list to delete the score for.
It uses the `ParserUtil` to parse the input string, extracting the `index`.
It also ensures that the `index` is valid, and that there are no duplicate prefixes (i.e. there is only one `index` value) in the user input.
The `index` is then used in instantiating the `DeleteScoreCommand` by the `DeleteScoreCommandParser`.

The following sequence diagram illustrates the parsing of an `deleteScore` command with the user input `deleteScore 1`:

<p align="center">
    <puml src="diagrams/DeleteScoreParsingSequenceDiagram.puml" alt="Sequence Diagram for Parsing of addScore command" />
</p>

##### Executing the Command

The `execute` method in `DeleteScoreCommand` retrieves the `filteredPersons` list in `Model`, and validates the target index against the list of filtered persons to ensure it is not out of bounds.
It then fetches the person to delete the score for based on the target index.
It also retrieves the currently selected exam from the `Model`.
It removes the score for the selected exam in the person's existing `scores` hashmap using the `removeExamScoreFromPerson` method in `Model`.

<p align="center">
    <puml src="diagrams/DeleteScoreExecutionSequenceDiagram.puml" alt="Sequence Diagram for Parsing of addScore command" />
</p>

<br>

<div id="importexamscores"></div>

#### **Import Exam Scores Command** : `importExamScores`

The `importExamScores` command lets users import exam scores corresponding to existing exams and persons from a CSV file.

##### Parsing User Input

The `ImportExamScoresParser` class is responsible for parsing the user input. It uses the `ArgumentTokenizer` to tokenize the input string, extracting the file path of the CSV file to be imported.

##### Executing the Command

**Parsing CSV File** <br>

The `ImportExamScoresCommand` class reads the CSV file with the given file path.
The CSV file is parsed with the `OpenCSV` library and a `List<String[]>` is created, with each `String[]` representing a row in the CSV file.

**File Validation** <br>

After parsing, a mapping of `Exam` objects to an inner mapping of an `email` string to a `Double` score is created. This mapping is used to validate the data in the CSV file.
If the **file** is invalid, an error message is returned.

The validation workflow for the **file** is as follows:

<p align="center"><puml src="diagrams/ImportExamScoresFileActivityDiagram.puml" alt="Activity Diagram for Import Exam Scores File Validation" /></p>

If the file is valid, any invalid entries will be ignored, with the rest being successfully processed.

A **column** will be ignored if:
1. The column header is not the `email` column, but does not start with `Exam:`.
2. The column header's name does not correspond to an existing `Exam` object. (i.e. Anything after `Exam:` is not an existing exam name.)

A **row** will be ignored if:
1. The `email` value does not correspond to an existing `Person`.

A **cell** will be ignored if:
1. The `Double` representing the score for an existing `Person` and `Exam` is not a valid `Score`.

**Value Validation** <br>

For every valid row:

The `Double` is parsed into a `Score` object.

The `Model` object is then used to:
* Get the `Exam` object corresponding to the exam name in the row;
* Get the `Person` object corresponding to the email in the row;
* And finally add the `Score` object to the correct `Person` for the correct `Exam`.

<br>

##### Concrete Examples of Validation

For concrete examples of the validation process, [refer to the manual testing section of the `importExamScores` command](#importing-exam-scores-importexamscores).


<br>

<div id="scorestatistics"></div>

#### **Score Statistics Command**

The exam statistics feature allows users to view the mean and median scores of the selected exam. The statistics are displayed in the `StatusBarFooter` element of the UI on the right side.

The statistics are automatically updated whenever the selected exam is changed or when there are potential modifications to the scores of the selected exam.

When there are no scores for the selected exam, the statistics are displayed as `No scores available`. When no exam is selected, the statistics are not displayed at all.

##### Storage of Exam Statistics

The `ScoreStatistics` class is used to store the mean and median scores of the selected exam. The `Model` component stores the `ScoreStatistics` object for the currently selected exam as a `SimpleObjectProperty<ScoreStatistics>`.

##### Updating of Exam Statistics

the `ModelManager` class implements a `updateSelectedExamStatistics` and `getSelectedExamStatistics` method to update the statistics.

`updateSelectedExamStatistics` is called whenever the selected exam is changed or when there are potential modifications to the scores of the selected exam (deletion of a Person, adding of Score, etc.). This ensures that the `selectedExamStatistics` object is always kept up-to-date with the scores of the selected exam.

The sequence diagram below illustrates the interactions within the `Model` component when the score statistics are updated using the `selectExam` command as an example.

<p align="center"><puml src="diagrams/StatisticsSequenceDiagram.puml" alt="Sequence Diagram for Statistics Updating" /></p>

##### User Interface Interaction

The `StatusBarFooter` element of the UI is initialised with an `ObservableValue<ScoreStatistics>` object. This object is bound to the `selectedExamStatistics` object in the `Model` component and is retrieved using the `getSelectedExamStatistics` method.

Whenever a command is executed, the `StatusBarFooter` retrieves the updated statistics and displays them on the right side of the footer which can be seen at the bottom of the UI.

##### Considerations for Exam Statistics Command

**Storage of Exam Statistics** <br>

There were considerations to just avoid the storage of the statistics and calculate them on the fly whenever needed. However, this would have been inefficient as the statistics would have to be recalculated every time the selected exam is changed or when there are potential modifications to the scores of the selected exam. By storing the statistics, we can limit recalculations to only when necessary.

Furthermore, storing the statistics allows us to maintain the code structure of our UI component, which is designed to observe and retrieve data from the `Model` component. If the statistics were to be calculated on the fly, the UI component would have to either calculate the statistics itself or request the `Model` component to calculate the statistics, which would have complicated the code structure by introducing more dependencies between the UI and Model components.

**Using `ScoreStatistics` Class** <br>

The `ScoreStatistics` class was used to store the mean and median scores of the selected exam. This class was chosen as it provides a clean and structured way to store the statistics. The class also provides extensibility, as additional statistics can easily be added in the future by extending the class.

<br>

--------------------------------------------------------------------------------------------------------------------

<div id="planned-enhancements"></div>

## **Planned Enhancements**

<br>

#### Enhance Input Validation for `find` Command

Currently, the `find` command only validates the `lt` and `mt` prefixes, where other prefixes are not validated. This means that users may search for persons with fields that do not exist to begin with, which is guaranteed to return no results.

##### Planned Implementation

We plan to enhance the `find` command to validate all prefixes other than `lt` and `mt`. This will ensure that users are not able to search for persons with fields that do not exist in the `Person` object.

However, we need to be careful about overzealous input validation where users may still want to search for fields using incomplete parts of a field, and hence we have to balance these two considerations.

For example, an extreme case will be to search for persons with the `Name` field with `~`, which is disallowed to begin with as `~` is not a valid character for a name. We plan to inform the user outright that the search is invalid and will not return any results.

<br>

#### Update UI to Wrap Text

Currently, the `ResultDisplay` box does not wrap text, which means that long lines of text will extend beyond the width of the box. This results in the need for two scrollbars, a horizontal one for the result box and a vertical one for the currently shown list of persons. This is not ideal as it makes the UI less optimized for the target audience, who prefer using a CLI-optimized application and prefer not to use mouse controls to scroll through scrollboxes.

##### Planned Implementation

We plan to modify the `ResultDisplay` box to wrap text so that there is no longer a need for the horizontal scrollbar in the `ResultDisplay` box.

In the case where the wrapped text still exceeds the height of the `ResultDisplay` box, we plan to enable it to dynamically adjust its height as needed.

<br>

#### Primary Key: Use Both `Matric` and `Email`

Currently, only `Email` is used as a unique identifier for `Person` objects. However, this means that two `Person` objects can have different `Email`s but the same `Matric` number. This clashes with the real-life constraint that NUS students, in particular CS1101S students, are put under, where Matriculation numbers are supposed to be unique for each student. Our planned enhancement hence aims to better reflect real-life constraints.

##### Planned Implementation

Currently, the `hasPerson` method in the `Model` class checks for the existence of a `Person` object based on the `Email` field. We plan to modify this method to check for the existence of a `Person` object based on both the `Email` and `Matric` fields. This will ensure that two `Person` objects cannot have the same `Matric` number.

However, more checking needs to be done to ensure persons cannot have different overall unique identifiers, but the same `Email` or `Matric` field. (E.g. two persons cannot have the same `Email` but different `Matric` numbers.)

Additionally, some persons such as staff members and course instructors may not have a `Matric` field. Hence, careful consideration needs to be made to implement this new method of checking for unique identifiers.

<br>

#### UX: Make Sample Data Tags More Relevant and Helpful to the User

Currently, the sample data tags are not very helpful to the user, having tags like `friends`, `neighbours` and `family`. This may pose confusion to users about the context of the application, which is the head TA's management of persons related to CS1101S.

##### Planned Implementation

Remove all `Tag` objects that are in the sample data that border on irrelevancy. This can be done by modifying the `SampleDataUtil` class to not add these tags to the sample data.

Retain all other relevant `Tag` objects like `colleagues` and `student` to better reflect the context of the application.

<br>

--------------------------------------------------------------------------------------------------------------------
<div id="documentation"></div>

## **Documentation, Logging, Testing, Configuration, Dev-Ops**

* [Documentation guide](Documentation.md)
* [Testing guide](Testing.md)
* [Logging guide](Logging.md)
* [Configuration guide](Configuration.md)
* [DevOps guide](DevOps.md)

--------------------------------------------------------------------------------------------------------------------

<div id="appendix"></div>

## **Appendix**

<div id="appendix_a"></div>

### Appendix A: Product Scope

**Target user profile**:

* Name: Sarah Johnson
* Age: 23
* Occupation: Head Tutor for CS1101S

* head tutor for CS1101S course
* has a need to manage various aspects of course administration
* has a need to schedule classes
* has a need to coordinate with teaching assistants
* has a need to effectively communicate with students
* has a need to manage a significant number of persons
* prefer desktop apps over other types
* can type fast
* prefers typing to mouse interactions
* is reasonably comfortable using CLI apps

**Value proposition**:

* manage persons faster than a typical mouse/GUI driven app
* Centralised platform to store and manage person details for all relevant individuals involved in course administration
* Able to store and manage exam scores for all students in the course
* Easier access to information through organising relevant persons into different subgroups
* Able to set up the address book through different data-loading options
* Able to assist with management of large scale communication

**Problem scope**:

* The CS1101S Head Tutor will face challenges in effectively organising and managing contact information within the department due to the large scale the course has to operate on. Existing methods, such as paper-based lists or basic digital spreadsheets, lack the necessary functionality to efficiently handle the diverse needs of proper contact management. There is a need for a user-friendly and offline-capable address book solution tailored specifically to the needs of a single user. This address book system should provide features such as easy contact entry and editing, quick search functionality, customizable categorization options, and the ability to add notes for each contact. Additionally, it should operate offline without requiring an internet connection and should not rely on complex database management systems.
* While the address book system will greatly improve contact management and organisation for the CS1101S Head Tutor, it will not address broader departmental communication or collaboration needs beyond individual contact management since the address book is designed to be a single-user system. It will not facilitate communication between users or provide collaboration tools for group projects or tasks. Additionally, the address book system will not handle complex data analysis or reporting functions beyond basic contact information management. Finally, while the system will provide offline functionality, it will not offer real-time synchronisation with online databases or cloud storage solutions.

<div id="appendix_b"></div>

### Appendix B: User Stories

Priorities: High (must have) - `* * *`, Medium (nice to have) - `* *`, Low (unlikely to have) - `*`

#### General

| Priority | As a …​                                      | I want to …​                            | So that I can…​                                                          |
|----------|---------------------------------------------|----------------------------------------|-------------------------------------------------------------------------|
| `* * *`  | potential user exploring the app            | see the app populated with sample data | immediately see an example of the app in use                            |
| `* * *`  | new user                                    | see usage instructions                 | refer to instructions when I forget how to use the App                  |
| `* * *`  | new user                                    | easily clear the example data          | start using the app with real-life data                                 |
| `* *`    | experienced user                            | use the address book offline           | update and interact with it anywhere                                    |

#### For Contact Management

| Priority | As a …​                                      | I want to …​                            | So that I can…​                                                          |
|----------|---------------------------------------------|----------------------------------------|-------------------------------------------------------------------------|
| `* * *`  | head tutor using the app                    | import persons from a csv file         | easily add a large number of persons to the address book                |
| `* * *`  | new user                                    | save the data I input into the app     | don't lose the information I've entered                                 |
| `* * *`  | user                                        | add a new person                       | make minor additions to the persons in the address book                 |
| `* * *`  | user                                        | update and edit person details         | keep my address book accurate                                           |
| `* * *`  | user                                        | delete a person                        | remove entries that I no longer need                                    |
| `* * *`  | user                                        | delete a specific group of entries     | remove multiple entries that I no longer need more efficiently          |
| `* * *`  | user                                        | view all saved contacts                | oversee the data stored within my app                                   |
| `* * *`  | user                                        | find a person through their particulars| locate details of persons without having to go through the entire list  |
| `* * *`  | head tutor using the app                    | categorise my persons into groups      | manage different groups of students effectively                         |
| `* * *`  | head tutor using the app                    | copy email addresses of a group        | effectively communicate with target groups                              |
| `* * *`  | head tutor using the app                    | export the details of persons to a csv | easily share the details of a group with others                         |

#### For Exam and Score Management

| Priority | As a …​                                      | I want to …​                            | So that I can…​                                                          |
|----------|---------------------------------------------|----------------------------------------|-------------------------------------------------------------------------|
| `* * *`  | head tutor using the app                    | import assesment scores from a csv file| easily add a large number of scores to the address book                 |
| `* * *`  | head tutor using the app                    | add exams to the app                   | keep track of student performance                                       |
| `* * *`  | head tutor using the app                    | delete exams from the app              | remove exams that are no longer relevant                                |
| `* * *`  | head tutor using the app                    | view scores for a specific exam        | analyse student scores                                                  |
| `* * *`  | head tutor using the app                    | add scores to the app                  | keep track of student performance                                       |
| `* * *`  | head tutor using the app                    | edit scores in the app                 | correct errors in the scores                                            |
| `* * *`  | head tutor using the app                    | delete scores from the app             | remove scores that are no longer relevant                               |
| `* * *`  | head tutor using the app                    | export scores to a csv file            | easily share the scores with others                                     |
| `* * *`  | head tutor using the app                    | view statistics of scores              | analyse student performance                                             |


<div id="appendix_c"></div>

--------------------------------------------------------------------------------------------------------------------

### Appendix C: Use Cases

(For all use cases below, the **System** is the `AddressBook` and the **Actor** is the `user`, unless specified otherwise)

##### Use Case: UC01 — Getting Help

**MSS:**

1.  User requests help information.
2.  AddressBook copies the link to the user guide to the user's clipboard.
3.  User pastes the link into a browser to access the user guide.

    Use case ends.

##### Use Case: UC02 — Clearing Sample Data

**MSS:**

1.  User requests to clear the sample data.
2.  AddressBook clears the sample data.
3.  AddressBook displays a message indicating that the sample data has been cleared.

    Use case ends.

##### Use Case: UC03 — Importing Person Details from a CSV File

**MSS:**

1.  User requests to import person details from a CSV file.
2.  AddressBook imports the person details from the CSV file.
3.  AddressBook displays a message indicating that the person details have been imported.

    Use case ends.

**Extensions:**

*  1a. The file to be imported is not a CSV file.

    *  1a1. AddressBook displays an error message indicating that the file type is not recognised and should be a csv file.

       Use case ends.

*  1b. AddressBook cannot find the file to be imported.

    *  1b1. AddressBook displays a message indicating that the file is not recognised.

       Use case ends.

##### Use Case: UC04 — Adding a Person

**MSS:**

1.  User requests to add a new person and inputs details for the new person.
2.  AddressBook saves the new person's information.
3.  AddressBook confirms the addition of the new person.

    Use case ends.

**Extensions:**

*  1a. User does not input all compulsory parameters along with the person.

    *  1a1. AddressBook prompts the user on the proper usage of the command.

       Step 1a1 is repeated until the data entered is correct.

       Use case resumes at step 2.

*  1b. User tries to add a person with an existing email address.

    *  1b1. AddressBook displays an error message informing the user that the email address already exists.

       Step 1b1 is repeated until a valid email address is entered.

       Use case resumes at step 2.

##### Use Case: UC05 — Editing a Person's Details

**MSS:**

1.  User requests to edit a specific person with updated details.
2.  AddressBook saves the updated details.
3.  AddressBook confirms the successful update.

    Use case ends.

**Extensions:**

*   1a. User does not input enough parameters along with the person.

    *  1a1. AddressBook prompts the user on the proper usage of the command.

       Step 1a1 is repeated until the data entered is correct.

       Use case resumes at step 2.

*   1b. The selected person does not exist.

    *  1b1. AddressBook displays an error message indicating that the person does not exist.

       Use case ends.

##### Use Case: UC06 — Deleting a Person

**MSS:**

1.  User !!requests to list persons (UC08)!!
2.  AddressBook shows a list of persons
3.  User requests to delete a specific person in the list
4.  AddressBook deletes the person

    Use case ends.

**Extensions:**

*   2a. The list is empty.

    Use case ends.

*   3a. The given index is invalid.

    *  3a1. AddressBook shows an error message.

       Use case resumes at step 2.

##### Use Case: UC07 — Deleting All Shown Persons

**MSS:**

1. User !!requests to find group of persons (UC09)!! by desired requirements
2. User requests to delete all listed persons.
3. AddressBook deletes all listed persons.
4. AddressBook displays a message to confirm that all listed persons have been deleted.

    Use case ends.

**Extensions:**

*   2a. No persons are listed.

    *  2a1. AddressBook displays a message indicating that there is no persons to delete.

       Use case ends.

*   2b. User has a filtered view that contains all existing persons.

    *  2b1. AddressBook displays a message indicating that all persons cannot be deleted at once.

       Use case ends.

##### Use Case: UC08 — Listing All Persons

**MSS:**

1.  User requests to list persons.
2.  AddressBook shows the list of persons.
3.  User views the list of persons.

    Use case ends.

**Extensions:**

*   2a. The list is empty.

    *  2a1. AddressBook displays a message indicating that the list is empty.

       Use case ends.

##### Use Case: UC09 — Finding Persons

**MSS:**

1.  User requests to find a specific group of persons matching the search criteria.
2.  AddressBook displays a list of persons matching the criteria.

    Use case ends.

**Extensions:**

*   1a. No persons match the search criteria.

    *  1a1. AddressBook displays a message indicating that no persons match the search criteria.

       Use case ends.

##### Use Case: UC10 — Copying Email Addresses

**MSS:**

1.  User requests to copy emails of currently displayed persons.
2.  AddressBook copies the emails of currently displayed persons
into user's clipboard.
3.  AddressBook notifies the user that emails have been copied.
4.  User can paste emails when composing emails.

    Use case ends.

**Extensions:**

*   2a. No persons currently displayed.

    *  2a1. AddressBook displays a message indicating that no persons are currently displayed.

       Use case ends.

##### Use Case: UC11 — Exporting Persons to CSV

**MSS:**

1. User !!requests to filter persons (UC09)!! by desired requirements
2. User requests to export all listed persons and details to a CSV file.
3. AddressBook exports the persons to a CSV file.
4. AddressBook displays a message to confirm that all listed persons have been exported to a CSV file.

    Use case ends.

**Extensions:**

*   2a. No persons are listed.

    *  2a2. AddressBook displays a message indicating that there is no persons to export.

       Use case ends.

##### Use Case: UC12 — Importing Exam Results from a CSV File

**MSS:**

1. User requests to import exam results from a csv file.
2. AddressBook displays a message that all exam results have been imported.

    Use case ends.

**Extensions:**

*   2a. AddressBook cannot find the file specified.

    *  2a1. AddressBook displays a message indicating that the file is not recognised.

       Use case ends.

*   2b. The file to be imported is not a csv file.

    *  2b1. AddressBook displays an error message indicating that the file type is not recognised and should be a csv file

       Use case ends.

*   2c. There are duplicate entries in the csv file.

    *  2c1. AddressBook displays a message indicating that there are duplicate entries in the csv file, and only the first instance has been kept.

       Use case ends.

* 2d. The csv file contains invalid entries.

    *  2d1. AddressBook displays a message indicating that there are invalid entries in the csv file, and all other valid entries have been imported.

       Use case ends.

##### Use Case: UC13 — Adding an Exam

**MSS:**

1. User requests to add an exam.
2. AddressBook displays a message that the exam has been added.

    Use case ends.

**Extensions:**

*   1a. User does not input all compulsory parameters along with the exam.

    *  1a1. AddressBook prompts the user on the proper usage of the command.

       Step 1a1 is repeated until the data entered is correct.

       Use case resumes at step 2.

*   1b. User tries to add an exam with an existing name.

    *  1b1. AddressBook displays an error message informing the user that the exam name already exists.

       Step 1b1 is repeated until a valid exam name is entered.

       Use case resumes at step 2.

*   1c. User tries to add an exam with an invalid score.

    *  1c1. AddressBook displays an error message informing the user that the score is invalid.

       Step 1c1 is repeated until a valid score is entered.

       Use case resumes at step 2.

*   1d. User tries to add an exam with an invalid name.

    *  1d1. AddressBook displays an error message informing the user that the name is invalid.

       Step 1d1 is repeated until a valid name is entered.

       Use case resumes at step 2.

##### Use Case: UC14 — Deleting an Exam

**MSS:**

1. User requests to delete an exam.
2. AddressBook displays a message that the exam has been deleted.

    Use case ends.

**Extensions:**

*   1a. The exam does not exist.

    *  1a1. AddressBook displays an error message indicating that the exam does not exist.

       Use case ends.

##### Use Case: UC15 — Selecting an Exam

**MSS:**

1. User requests to select an exam.
2. AddressBook displays the scores of the selected exam.

    Use case ends.

**Extensions:**

*   1a. The exam does not exist.

    *  1a1. AddressBook displays an error message indicating that the exam does not exist.

       Use case ends.

##### Use Case: UC16 — Deselecting an Exam

**MSS:**

1. User requests to deselect an exam.
2. AddressBook displays the persons without the scores of the selected exam.

    Use case ends.

**Extensions:**

*   1a. The exam does not exist.

    *  1a1. AddressBook displays an error message indicating that the exam does not exist.

       Use case ends.

##### Use Case: UC17 — Adding Scores to a Student for an Exam

**MSS:**

1. User !!requests to select an exam (UC15)!! to add scores to.
2. User requests to add scores to a student for the selected exam.
3. AddressBook displays a message that the scores have been added.

    Use case ends.

**Extensions:**

*   2a. The student does not exist.

    *  2a1. AddressBook displays an error message indicating that the student does not exist.

       Use case ends.

*   2b. The student already has a score for the exam.

    *  2b1. AddressBook displays an error message indicating that the student already has a score for the exam.

       Use case ends.

##### Use Case: UC18 — Editing Scores for a Student for an Exam

**MSS:**

1. User !!requests to select an exam (UC15)!! to edit scores for.
2. User requests to edit scores for a student for the selected exam.
3. AddressBook displays a message that the scores have been edited.

    Use case ends.

**Extensions:**

* 2a. The student does not exist.

    * 2a1. AddressBook displays an error message indicating that the student does not exist.

       Use case ends.

* 2b. The student does not have a score for the exam.

    * 2b1. AddressBook displays an error message indicating that the student does not have a score for the exam.

        Use case ends.

* 2c. The score is invalid.

    * 2c1. AddressBook displays an error message indicating that the score is invalid.

        Use case ends.

##### Use Case: UC19 — Deleting Scores for a Student for an Exam

**MSS:**

1. User !!requests to select an exam (UC15)!! to delete scores for.
2. User requests to delete scores for a student for the selected exam.
3. AddressBook displays a message that the scores have been deleted.

    Use case ends.

**Extensions:**

*   2a. The student does not exist.

    *  2a1. AddressBook displays an error message indicating that the student does not exist.

       Use case ends.

*   2b. The student does not have a score for the exam.

    *  2b1. AddressBook displays an error message indicating that the student does not have a score for the exam.

        Use case ends.

##### Use Case: UC20 — Viewing Statistics of Scores

**MSS:**

1. User !!requests to select an exam (UC15)!! to view statistics of scores for.
2. AddressBook displays the statistics of scores for the selected exam.

    Use case ends.

**Extensions:**

*  2a. There are no scores for the exam.

    *  2a1. AddressBook does not display any statistics.

       Use case ends.

##### Use Case: UC21 — Exit Application

**MSS:**

1.  User requests to exit the application.
2.  AddressBook exits the application.

    Use case ends.

--------------------------------------------------------------------------------------------------------------------

<div id="appendix_d"></div>

### Appendix D: Non-Functional Requirements

1.   Should work on any _mainstream OS_ as long as it has Java `11` or above installed.
2.   Should be able to hold up to 2000 persons without a noticeable sluggishness in performance for typical usage.
3.   A user with above average typing speed for regular English text (i.e. not code, not system admin commands) should be able to accomplish most of the tasks faster using commands than using the mouse.
4.   A user should be able to import up to 2000 persons from an external source without a noticeable sluggishness in performance for typical usage.
5.   The application should provide comprehensive documentation and help resources to assist users in understanding how to use the software effectively.

--------------------------------------------------------------------------------------------------------------------

<div id="appendix_e"></div>

### Appendix E: Glossary

* **OS** : Operating System
* **Mainstream OS**: Windows, Linux, MacOS
* **CLI**: Command Line Interface
* **CSV**: Comma Separated Values - a file format used to store tabular data
* **MSS**: Main Success Scenario
* **UI**: User Interface
* **GUI**: Graphical User Interface
* **API**: Application Programming Interface - used to define how the components of this software interact with each other
* **Matric**: Matriculation number of a student

--------------------------------------------------------------------------------------------------------------------

<div id="appendix_f"></div>

### Appendix F: Instructions for Manual Testing

Given below are instructions to test the app manually.

<box type="info" seamless>

**Note:** These instructions only provide a starting point for testers to work on;
testers are expected to do more *exploratory* testing.

</box>

<div id="test_launch"></div>

#### Launch and Shutdown

1. Initial launch.
   * **Test case:** Launching the app for the first time.<br>
   
     1. Download the jar file and copy into an empty folder.
     2. Open Terminal and type the following:

        ```bash
        java -jar avengersassemble.jar
        ```
       **Expected:** Shows the GUI with a set of sample persons. The window size may not be optimal.
     <br><br>
2. Saving window preferences.
    * **Test case:** Saving the window size and location.
       1. Resize the window to an optimal size.
       2. Move the window to a different location.
       3. Close the window.
       4. Relaunch the app.<br><br>

       **Expected:** The most recent window size and location is retained.

3. Shutdown.
    * **Test case:** `exit`<br>
      **Expected:** The GUI closes and the application exits.

<br>

<div id="test_save"></div>

#### Saving Data

1. Dealing with missing or corrupted data files.

    * **Prerequisites:**
        * The app is a clean state.
          <br><br>
    * **Test case:** Deleting the storage file.
      1. Launch the app.
      2. Exit the app.
      3. Note that a new `data/avengersassemble.json` file is created. This is the storage file.
      4. Test case:** Delete the `data/avengersassemble.json` file.
      5. Relaunch the app.
      6. Exit the app.<br><br>

      **Expected:** A new `data/avengersassemble.json` file populated with sample data is created.
      <br><br>
    * **Test case:** Corrupt the `data/avengersassemble.json` file by adding random text to it.<br>
      **Expected:** The app should ignore the corrupted file and create a new empty `data/avengersassemble.json` file when launched and interacted with.

<div id="test_help"></div>

#### Getting Help

1. Test case: `help`<br>

   Expected: Link to the user guide is copied to the clipboard. Status message shows that the link has been copied. The link should be accessible from a browser.

<div id="test_clear"></div>

#### Clearing All Persons and Exams: `clear`

1. Prerequisites: Multiple persons in the list.

2. Test case: `clear`<br>

   Expected: All persons are deleted from the list. Status message shows the number of persons deleted.

<br>

<div id="test_import"></div>

#### Importing Persons: `import`

##### Importing Data from a CSV File

1. Prerequisites: Prepare a CSV file with a few persons. There isa file at path C:file.csv with the following content:

    ```
    name,email,address,phone
    alice,alice@gmail,wonderland,123
    ```

2. Test case: `import i|file.csv`<br>
        Expected: Persons from the CSV file are added to the address book. Status message shows the number of persons imported.

##### Importing Data from a CSV File that does not Exist

1. Prerequisites: No CSV file at the path C:file.csv

2. Test case: `import i|file.csv` <br>
   Expected: Error message shown in the error report. No change in the address book.

##### Importing Data from a CSV File that is not a CSV File

1. Prerequisites: A file at the path C:file.txt with the following content:

    ```
    name,email,address,phone
    alice,alice@gmail,wonderland,123
    ```

2. Test case: `import i|file.txt` (file is not a CSV file)<br>
       Expected: Error message shown in the error report. No change in the address book.

##### Importing Data from a CSV File with Duplicate Compulsory Headers in Header Row

1. Prerequisites: A CSV file with duplicate compulsory headers (e.g. 2 header columns named 'name') at the path C:file.csv with the following content:

    ```
    name,email,address,phone,name
    alice,alice@gmail.com,123,123,bob
    ```

2. Test case: `import i|file.csv` (file has duplicate headers)<br>
       Expected: First occurrence in the CSV file is added to the address book. Duplicate entries are ignored.

##### Importing Data from a CSV File with Missing Compulsory Headers in Header Row

1. Prerequisites: A CSV file with missing compulsory headers at the path C:file.csv with the following content:

    ```
    email,address,phone
    Alice@gmail.com,123,123
    ```

3. Test case: `import i|file.csv` (file has missing headers)<br>
       Expected: Error message shown in the error report. No change in the address book.

##### Importing Data from a CSV File with Missing Compulsory Values in a Row

1. Prerequisites: A CSV file with missing compulsory values in a row at the path C:file.csv with the following content:

     ```
     name,email,address,phone
     Alice,,123,123
     ```

2. Test case: `import i|file.csv` <br>
       Expected: All valid rows are added to the address book. Error message shown in the error report for invalid rows.

##### Importing Data from a CSV File with Extra Headers in Header Row

1. Prerequisites: A CSV file with extra headers in header row at the path C:file.csv with the following content:


     ```
     name,email,address,phone,extra
     Alice,alice@gmail.com,123,123,extra
     ```

2. Test case: `import i|file.csv` (file has extra headers)<br>
   Expected: Only the compulsory headers are read. Optional headers are read if present. Extra headers are ignored.

##### Importing Data from a CSV File with Unequal Number of Values in a Row as the Number of Headers

1. Prerequisites: A CSV file with extra values in a row at the path C:file.csv with the following content:

     ```
     name,email,address,phone,matric
     Alice,alice@gmail.com,123,123
     ```

2. Test case: `import i|file.csv` (file has extra values in a row)<br>
       Expected: All valid rows are added to the address book. Error message shown in the error report for invalid rows.

##### Importing Data from an Empty CSV File

1. Prerequisites: An empty CSV file at the path C:file.csv

2. Test case: `import i|file.csv` (file is empty CSV file)<br>
  Expected: Error message shown in the error report. No change in the address book.

<br>

<div id="test_add"></div>

#### Adding a Person: `add`

**Command:** `add`<br>
**More information on usage:** <a href="UserGuide.md#add">Adding a Person</a>

1. Adding a person with all fields.

    * **Prerequisites:**
        * No persons in the list.
          <br><br>
    * **Test case:** `add n|Alice p|98765432 a|Hall e|e09123456@u.nus.edu m|A1234567X r|R2 s|S1 t|excelling`<br>
    **Expected:** A person with the following fields is added to the list:
        * Name: `Alice`
        * Phone: `98765432`
        * Address: `Hall`
        * Email: `e09123456@u.nus.edu`
        * Matric: `A1234567X`
        * Reflection: `R2`
        * Studio: `S1`
        * Tags: `excelling`, `student`

    <box type="info" seamless>

    **Note:** If a `Matric` number is provided, the person is automatically tagged as a `student`.

    </box>

    * **Test case (missing `Address` and `Phone` fields):** `add n|Alice e|e09123456@u.nus.edu`<br>
    **Expected:** An error message is shown indicating that the `Address` and `Phone` fields are missing.
    <br><br>


2. Adding a person with repeated prefixes.

    * **Prerequisites:**
        * No persons in the list.
        <br><br>
    * **Test case (repeating `Name` field):** `add n|Ali n|Ali p|98765432 a|Hall e|test@test.com m|A1234567X`<br>
    **Expected:** An error message is shown indicating that the `Name` field is repeated.
    <br><br>


3. Adding a person whose `Email` already exists.

    * **Prerequisites:**
        * A person with email `e1234567@u.nus.edu` already exists in the list.
        <br><br>
    * **Test case (changing `Email` to a currently existing one):** `add n|Alice p|987 a|Hall e|e1234567@u.nus.edu`<br>
    **Expected:** An error message is shown indicating that the email already exists.
    <br><br>

4. Adding a person with only compulsory fields.

    * **Prerequisites:**
        * No persons in the list.
        <br><br>
    * **Test case:** `add n|Alice p|98765432 a|Hall e|e09123456@u.nus.edu`<br>
    **Expected:** A person with the following fields is added to the list:
        * Name: `Alice`
        * Phone: `98765432`
        * Address: `Hall`
        * Email: `e09123456@u.nus.edu`
    <br><br>

5. Adding a person with matriculation number

    * **Prerequisites:**
        * No persons in the list.
        <br><br>
    * **Test case:** `add n|Alice p|98765432 a|Hall e|alice@example.com m|A1234567X`<br>
    **Expected:** A person with the following fields is added to the list:
        * Name: `Alice`
        * Phone: `98765432`
        * Address: `Hall`
        * Email: `alice@example.com`
        * Matric: `A1234567X`
        * Tags: `student`
        <br><br>
        Note that the `student` tag is automatically added to the new person.
    <br><br>
    * **Test case:** `add n|Alice p|98765432 a|Hall e|alice@example.com`<br>
    **Expected:** A person with the following fields is added to the list:
        * Name: `Alice`
        * Phone: `98765432`
        * Address: `Hall`
        * Email: `alice@example.com`
        <br><br>
    Note that there is no automatic tagging.
    <br><br>

<div id="test_edit"></div>

#### Editing a Person: `edit`

##### Editing a Person with All Fields

1. Prerequisites: Start with the provided sample data.

2. Test case:

    ```
    edit 1 n|new name p|123 a|new address e|newemail@example.com m|A0000000X r|R1 s|S1 t|tag1 t|tag2
    ```

   Expected: The first person’s details are updated with all the new values.

3. Other successful test cases include a combination of updating some fields and not updating others.

   Expected: Similar to previous.

##### Editing a Person with Repeated Prefixes

1. Prerequisites: Start with the provided sample data.

2. Test case: (Repeated `n|` prefix)

    ```
    edit 1 n|new name n|new name 2 p|123 a|new address
    ```

   Expected: An error message is shown indicating that the `Name` field is repeated.

3. Other incorrect test cases to try: Repeated `p|`, `a|`, `e|`, `m|`, `r|`, `s|`, `t|` prefixes.

   Expected: Similar to previous.

##### Editing a Person's `Email` to an Existing `Email`

1. Prerequisites: Start with the provided sample data. Note the emails of the first and second person.

2. Test case:

    ```
    edit 1 e|berniceyu@example.com
    ```

   Expected: An error message is shown indicating that the email already exists.

<div id="test_delete"></div>

#### Deleting a Person: `delete`

##### Deleting a Person while All Persons are Being Shown

1. Prerequisites: List all persons using the `list` command. Multiple persons in the list.

2. Test case: `delete 1`<br>

   Expected: First person is deleted from the list. Details of the deleted person shown in the status message.

3. Test case: `delete 0`<br>

   Expected: No person is deleted. Error details shown in the status message.

4. Other incorrect delete commands to try: `delete`, `delete x`, `...` (where x is larger than the list size)<br>

   Expected: Similar to previous.

##### Deleting a Person while Some Persons are Being Shown

1. Prerequisites: Filter persons using the `find` command. Multiple but not all persons in the list.

2. Test case: `delete 1`<br>

    Expected: First person in the filtered list is deleted. Details of the deleted person shown in the status message.

3. Test case: `delete 0`<br>

    Expected: No person is deleted. Error details shown in the status message.

4. Other incorrect delete commands to try: `delete`, `delete x`<br>

    Expected: Similar to previous.

##### Deleting a Person while No Persons are Being Shown

1. Prerequisites: Filter persons using the `find` command such that there are no persons in the list, or delete all persons with `clear`.

2. Test case: `delete 1`<br>

    Expected: No person is deleted. Error details shown in the status message.


<div id="test_deleteshown"></div>

#### Deleting Shown Persons: `deleteShown`

##### Deleting a Proper Subset of All Persons

1. Prerequisites: Filter persons using the `find` command such that there are multiple, but not all, persons in the list.

2. Test case: `deleteShown`

    Expected: All persons currently shown are deleted, and the list is updated to show all remaining persons.

3. Other successful test cases: `deleteShown x`

    Expected: Similar to previous, as extraneous parameters for single-word commands are treated as typos and ignored.

##### Deleting All Persons

1. Prerequisites: Filter persons using the `find` command such that all persons are shown, or list all persons with `list`.

2. Test case: `deleteShown`

    Expected: An error is shown indicating that all persons cannot be deleted at once.

3. Other incorrect test cases to try: `deleteShown x`

    Expected: Similar to previous.

<div id="test_list"></div>

#### Listing All Persons: `list`

##### Starting with Sample Data

1. Prerequisites: Start with the provided sample data.

2. Test case: `list`

    Expected: All persons are shown in the list.

3. Other successful test cases: `list x`

    Expected: Similar to previous, as extraneous parameters for single-word commands are treated as typos and ignored.

##### Starting with a Filtered List

1. Prerequisites: Filter persons using the `find` command such that there are multiple, but not all, persons in the list.

2. Test case: `list`

    Expected: All persons in the overall list are shown.

<div id="test_find"></div>

#### Finding a Person: `find`

##### Finding a Person by Contact Details

1. Prerequisites: Multiple persons in the list.

2. Test case: `find n|Alice`<br>

    Expected: Persons with the name "Alice" are shown. Status message shows the number of persons found.

3. Test case: `find e|alice`<br>

    Expected: Persons with emails that contain the word "alice" are shown. Status message shows the number of persons found.

4. Test case: `find p|123`<br>

    Expected: Persons with phone numbers that contain the digits "123" are shown. Status message shows the number of persons found.

5. Test case: `find a|Ang Mo Kio`<br>

    Expected: Persons with addresses that contain the word "Ang Mo Kio" are shown. Status message shows the number of persons found.

5. Test case: `find t|student`<br>

    Expected: Persons with the tag "student" are shown. Status message shows the number of persons found.

6. Test case: `find m|A123`<br>

    Expected: Persons with matriculation numbers containing "A123" are shown. Status message shows the number of persons found.

7. Test case: `find r|R01`<br>

    Expected: Persons with the reflection "R01" are shown. Status message shows the number of persons found.

8. Test case: `find s|S01`<br>

    Expected: Persons with the studio "S01" are shown. Status message shows the number of persons found.

<box type="info" seamless>

**Note:**
* Search is not case sensitive
* Finds persons with the **search parameter** that contains the given word (except reflection and studio, which must match exactly).
* The search parameter can be any part of the person's details, e.g. name, email, etc. and is specified by the prefix.

</box>

##### Finding by Score

1. Prerequisites: Multiple persons in the list. Persons with scores. Exam must be selected.

2. Test case: `find lt|50`<br>

    Expected: Persons with scores less than 50 are shown. Status message shows the number of persons found.

3. Test case: `find mt|50`<br>

    Expected: Persons with scores more than 50 are shown. Status message shows the number of persons found.

4. Test case: `find lt|-1`<br>

    Expected: An error message is shown indicating that the `score` provided is invalid.

5. Test case: `find mt|101`<br>

    Expected: An error message is shown indicating that the `score` provided is greater than the maximum score of the selected exam. (Assuming the maximum score is 100)

<box type="info" seamless>

**Note:**
* The range of scores searched is exclusive of the given score. E.g. `find lt|50` will not include persons with a score of 50.
* You can search for scores from 0 to the maximum score of the selected exam, inclusive.

</box>

##### Finding by Multiple Prefixes

1. Prerequisites: Multiple persons in the list.

2. Test case: `find n|Alice e|Alice`<br>

    Expected: An error message is shown indicating that the format of the command is incorrect.

3. Other incorrect test cases to try: any combination of two or more unique prefixes<br>

    Expected: Similar to previous.

4. Test case: `find n|Alice n|Bob`<br>

    Expected: An error message is shown indicating that the prefix `n` is duplicated.

5. Other incorrect test cases to try: Repeated `p|`, `a|`, `e|`, `m|`, `r|`, `s|`, `t|`, `mt|`, `lt|` prefixes.

    Expected: Similar to previous.

<div id="test_copy"></div>

#### Copying Emails: `copy`

##### Copying Emails of All Persons

1. Prerequisites: Multiple persons in the list. Use the `list` command to display all persons.

2. Test case: `copy`<br>

    Expected: All emails are copied to the clipboard. Status message shows the number of emails copied.

##### Copying Emails of a Specific Group

1. Prerequisites: Multiple persons in the list, filtered by a specific criteria using the `find` command.

2. Test case: `copy`<br>

    Expected: All emails of the currently displayed persons are copied to the clipboard. Status message shows the number of emails copied.

<box type="info" seamless>

**Note:**
* If no persons are displayed, an error message is shown.

</box>

<br>

<div id="test_export"></div>

#### Exporting Data to a CSV File: `export`

**Command:** `export`<br>
**More information on usage:** <a href="UserGuide.md#export">Exporting Data to a CSV File</a>

1. Exporting data while all persons are displayed.

    * **Prerequisites:**
        * Start with the provided sample data.
        * List all persons using the `list` command.
          <br><br>
    * **Test case:** `export`<br>
      **Expected:** A file named `addressbookdata` containing `avengersassemble.csv` is created in the same directory where the JAR file of the Avengers Assemble is located. All currently displayed persons and their details are exported to the CSV file.
      <br><br>

2. Exporting data while person list is filtered.

    * **Prerequisites:**
        * Start with the provided sample data.
        * Filter the person list using the `find` command.
          <br><br>
    * **Test case:** Similar to previous.<br>
      **Expected:** Similar to previous.
      <br><br>

3. Exporting data with exams and exam scores added.

    * **Prerequisites:**
        * Start with the provided sample data.
        * Add an exam using the `addExam` command. For this example, we shall add an exam with name `Test Exam`.
        * List all persons using the `list` command.
          <br><br>
    * **Test case:** `export`<br>
      **Expected:** A file named `addressbookdata` containing `avengersassemble.csv` is created in the same directory where the JAR file of the Avengers Assemble is located. All currently displayed persons and their details are exported to the CSV file. A column with column heading `Exam:Test Exam` is present in the same CSV file, but no values present in that column.
      <br><br>
    * **Test case:** Add exam scores to persons in displayed list using `addScore`, then `export`<br>
      **Expected:** A file named `addressbookdata` containing `avengersassemble.csv` is created in the same directory where the JAR file of the Avengers Assemble is located. All currently displayed persons and their details are exported to the CSV file. A column with column heading `Exam:Test Exam` is present in the same CSV file, with corresponding exam scores for each person included in that column.

<br>

<div id="test_addexam"></div>

#### Adding an Exam: `addExam`

##### Adding an Exam with Valid Data

1. Prerequisites: No exams in the address book.

2. Test case: `addExam n|Midterm s|100`<br>
   Expected: New exam is added to the address book. Status message shows the exam added.

3. Other test cases to try: `addExam n|Final s|100`<br>
   Expected: New exam is added to the address book. Status message shows the exam added.

##### Adding an Exam that Already Exists

1. Prerequisites: An exam of name: Final, Score: 100 exists in the address book.

2. Test case: `addExam n|Final s|100`<br>
   Expected: Error message shown in the error report. No change in the address book.

##### Adding an Exam with Missing Fields

1. Pre-requisite: No exams in the address book.

2. Test case: `addExam n|Final` (missing score)<br>
     Expected: Error message shown in the error report. No change in the address book.

<br>

<div id="test_deleteexam"></div>

#### Deleting an Exam: `deleteExam`

1. Prerequisites: Exactly one exam in the address book. Hence, exam has an index of 1.

2. Test case: `deleteExam 1`<br>
   Expected: First exam is deleted from the address book. Status message shows the exam deleted.

3. Test case: `deleteExam 0`<br>
   Expected: No exam is deleted. Error message shown. No change in the address book.

4. Test case: `deleteExam 2` (index out of bounds)<br>
   Expected: No exam is deleted. Error message shown. No change in the address book.

5. Test case: `deleteExam` (no index)<br>
   Expected: No exam is deleted. Error message shown. No change in the address book.

<br>

<div id="test_selectexam"></div>

#### Selecting an Exam: `selectExam`

1. Prerequisites: Exactly one exam in the address book. Hence, exam has an index of 1.

2. Test case: `selectExam 1`<br>
   Expected: First exam is selected. Status message shows the exam selected.

3. Test case: `selectExam 0`<br>
   Expected: No exam is selected. Error message shown. No change in the address book.

4. Test case: `selectExam 2` (index out of bounds)<br>
   Expected: No exam is selected. Error message shown. No change in the address book.

5. Test case: `selectExam` (no index)<br>
   Expected: No exam is selected. Error message shown. No change in the address book.

<div id="test_deselectexam"></div>

#### Deselecting an Exam: `deselectExam`

1. Prerequisites: An exam has been selected.

2. Test case: `deselectExam`<br>
   Expected: Selected exam is deselected. Status message shows the exam deselected.

3. Test case: `deselectExam` (no exam selected)<br>
   Expected: No exam is deselected. Error message shown. No change in the address book.

<br>

<div id="test_importexam"></div>

#### Importing Exam Scores: `importExamScores`

##### Importing Exam Scores from a CSV File

1. Prerequisites: Start with sample data.

2. Add an `Exam` to the sample data:

    ```
    addExam n|Midterm s|100
    ```

3. Create a CSV file with the following content:

    Contents of `/path/to/file.csv`:

    ```
    email,Exam:Midterm
    alexyeoh@example.com,50
    ```

4. Test case: `importExamScores /path/to/file.csv`

    Expected: The person with the email of `alexyeoh@example.com` now has a `Midterm` score of `50`.

##### Importing an Invalid File

1. Prerequisites: Start with sample data and the `Midterm` exam.

2. Create a file named `invalid.json`.

3. Test case: `importExamScores invalid.json`

    Expected: An error message is shown indicating that the file is not a CSV file.

##### Importing a CSV File with Incorrect Formatting

1. Prerequisites: Start with sample data and the `Midterm` exam.

2. Create a CSV file with the following content:

    Contents of `/path/to/file.csv`:

    ```
    email,Exam:Midterm,email
    alexyeoh@example.com,50,alexyeoh@example.com
    ```

3. Test case: `importExamScores /path/to/file.csv`

    Expected: An error message is shown indicating that the email header should exist only in the first column.

4. Other incorrect test cases to try: CSV files where email is not the first header.

    Expected: Similar to previous.

##### Importing a CSV File with Duplicate Entries

1. Prerequisites: Start with sample data and the `Midterm` exam.

2. Create a CSV file with the following content:

    Contents of `/path/to/file.csv`:

    ```
    email,Exam:Midterm,Exam:Midterm
   alexyeoh@example.com,50,60
    ```

3. Test case: `importExamScores /path/to/file.csv`

    Expected: A message is shown indicating that there are duplicate entries in the CSV file, and only the first instance has been kept. The `Midterm` score for the person with the email of `alexyeoh@example.com` is `50`.

##### Importing a CSV File with Invalid Entries

1. Prerequisites: Start with sample data and the `Midterm` exam.

2. Create a CSV file with the following content:

    Contents of `/path/to/file.csv`:

    ```
    email,Exam:Midterm,Exam:Finals
    alexyeoh@example.com,101,50
    berniceyu@example.com,50,60
    nonexistent@example.com,100,100
    ```

3. Test case: `importExamScores /path/to/file.csv`

    Expected: A message is shown indicating that there are invalid entries in the CSV file, and all other valid entries have been imported. The errors shown are as follows:

    * The score for `alexyeoh@example.com` for the `Midterm` exam is invalid.
    * The person with the email `nonexistent@example.com` does not exist in the given list.
    * The `Finals` exam does not exist.

    Note that the `Midterm` score for the person with the email of `berniceyu@example.com` is `50`.

4. Other incorrect test cases to try: CSV files with a mix of invalid scores, nonexistent emails, and nonexistent exams.

    Expected: Similar to previous.

<br>

<div id="test_addscore"></div>

#### Adding a Persons's Exam Score: `addScore`

**Command:** `addScore`<br>
**More information on usage:** <a href="UserGuide.md#addscore">Adding an Exam Score</a>

1. Adding a score to a person while all persons are displayed.

    * **Prerequisites:**
        * Ensure at least one exam is added using the `addExam` command. For this example, we shall add a new exam with name `test exam` and maximum score `100`.
        * Ensure an exam is selected using the `selectExam` command. For this example, we shall select `test exam` from above.
        * Ensure all persons are displayed using the `list` command.
          <br><br>
    * **Test case:** `addScore 1 s|100`<br>
      **Expected:** A score of `100` is added to the first person in the list of displayed persons. The score and the name of the corresponding person will be shown in the status message.
      <br><br>
    * **Test case:** `addScore 2 s|50.25`<br>
      **Expected:** A score of `50.25` is added to the second person in the list of displayed persons.The score and the name of the corresponding person will be shown in the status message.
      <br><br>
    * **Test case (invalid index input):** `addScore 0 s|100`<br>
      **Expected:** No score is added to any persons. Error details are shown in the status message.
      <br><br>
    * **Test case (no index input):** `addScore s|100`<br>
      **Expected:** No score is added to any persons. Error details are shown in the status message.
      <br><br>
    * **Test case (no score input):** `addScore 3 s|`<br>
      **Expected:** No score is added to any persons. Error details are shown in the status message.
      <br><br>
    * **Test case (score larger than maximum score is input):** `addScore 3 s|101`<br>
      **Expected:** No score is added to any persons. Error details are shown in the status message.
      <br><br>
    * **Test case (negative score input):** `addScore 3 s|-50`<br>
      **Expected:** No score is added to any persons. Error details are shown in the status message.
      <br><br>
    * **Test case (person already contains a score):** `addScore 1 s|50.25`<br>
      **Expected:** No score is added to any persons. Error details are shown in the status message.
      <br><br>
    * **Other incorrect `addScore` commands to try:** `addScore`, `addScore INDEX s|100` (where `INDEX` is larger than the list size), `addScore 3 s|SCORE` (where `SCORE` is non-numeric, is less than 0, more than the maximum score of the selected exams, and/or has more than 2 digits in its fractional part)<br>
      **Expected:** No score is added to any persons. Error details are shown in the status message.
      <br><br>

2. Adding a score to a person while person list is filtered.

    * **Prerequisites:**
        * Ensure at least one exam is added using the `addExam` command. For this example, we shall add a new exam with name `test exam` and maximum score `100`.
        * Ensure an exam is selected using the `selectExam` command. For this example, we shall select `test exam` from above.
        * Filter the person list using the `find` command.
          <br><br>
    * **Test case:** Similar to previous.<br>
      **Expected:** Similar to previous.

<br>

<div id="test_editscore"></div>

#### Editing a Person's Exam Score: `editScore`

**Command:** `editScore`<br>
**More information on usage:** <a href="UserGuide.md#editscore">Editing an Exam Score</a>

1. Editing a score of a person while all persons are displayed.

    * **Prerequisites:**
        * Ensure at least one exam is added using the `addExam` command. For this example, we shall add a new exam with name `test exam` and maximum score `100`.
        * Ensure an exam is selected using the `selectExam` command. For this example, we shall select `test exam` from above.
        * Ensure all persons are displayed using the `list` command.
        * Ensure that one person in the list has a score for the selected exam using the `addScore` command. For this example, we shall add a score of `100` to the first person in the list.
          <br><br>
    * **Test case:** `editScore 1 s|90`<br>
      **Expected:** The score of `100` is edited to `90` for the first person in the list of displayed persons. The score and the details of the corresponding person will be shown in the status message.
      <br><br>
    * **Test case (invalid index input):** `editScore 0 s|90`<br>
      **Expected:** No person's score is edited. Error details are shown in the status message.
      <br><br>
    * **Test case (no index input):** `editScore s|90`<br>
      **Expected:** No person's score is edited. Error details are shown in the status message.
      <br><br>
    * **Test case (no score input):** `editScore 1 s|`<br>
      **Expected:** No person's score is edited. Error details are shown in the status message.
      <br><br>
    * **Test case (score larger than maximum score is input):** `editScore 1 s|101`<br>
      **Expected:** No score is added to any persons. Error details are shown in the status message.
      <br><br>
    * **Test case (person does not contain any score):** `editScore 2 s|90`<br>
      **Expected:** No score is added to any persons. Error details are shown in the status message.
      <br><br>
    * **Other incorrect `editScore` commands to try:** `editScore`, `editScore INDEX s|90` (where `INDEX` is larger than the list size), `editScore 1 s|SCORE` (where `SCORE` is non-numeric, is less than 0, more than the maximum score of the selected exams, and/or has more than 2 digits in its fractional part)<br>
      **Expected:** No score is added to any persons. Error details are shown in the status message.
      <br><br>

2. Editing a score of a person while person list is filtered.

    * **Prerequisites:**
        * Ensure at least one exam is added using the `addExam` command. For this example, we shall add a new exam with name `test exam` and maximum score `100`.
        * Ensure an exam is selected using the `selectExam` command. For this example, we shall select `test exam` from above.
        * Filter the person list using the `find` command.
        * Ensure that one person in the list has a score for the selected exam using the `addScore` command. For this example, we shall add a score of `100` to the first person in the list.
          <br><br>
    * **Test case:** Similar to previous.<br>
      **Expected:** Similar to previous.

<br>

<div id="test_deletescore"></div>

#### Deleting a Person's Exam Score: `deleteScore`

**Command:** `deleteScore`<br>
**More information on usage:** <a href="UserGuide.md#deletescore">Deleting an Exam Score</a>

1. Deleting a score of a person while all persons are displayed.

    * **Prerequisites:**
        * Ensure at least one exam is added using the `addExam` command. For this example, we shall add a new exam with name `test exam` and maximum score `100`.
        * Ensure an exam is selected using the `selectExam` command. For this example, we shall select `test exam` from above.
        * Ensure all persons are displayed using the `list` command.
        * Ensure that one person in the list has a score for the selected exam using the `addScore` command. For this example, we shall add a score of `100` to the first person in the list.
          <br><br>
    * **Test case:** `deleteScore`<br>
      **Expected:** The score of `100` is deleted from the first person in the list of displayed persons. The details of the corresponding person will be shown in the status message.
      <br><br>
    * **Test case (invalid index input):** `deleteScore 0`<br>
      **Expected:** No person's score is deleted. Error details are shown in the status message.
      <br><br>
    * **Test case (person does not contain any score):** `deleteScore 2`<br>
      **Expected:** No person's score is deleted. Error details are shown in the status message.
      <br><br>
    * **Other incorrect `deleteScore` commands to try:** `deleteScore`, `deleteScore INDEX` (where `INDEX` is larger than the list size)<br>
      **Expected:** No person's score is deleted. Error details are shown in the status message.
      <br><br>

2. Deleting a score of a person while person list is filtered.

    * **Prerequisites:**
        * Ensure at least one exam is added using the `addExam` command. For this example, we shall add a new exam with name `test exam` and maximum score `100`.
        * Ensure an exam is selected using the `selectExam` command. For this example, we shall select `test exam` from above.
        * Filter the person list using the `find` command.
        * Ensure that one person in the list has a score for the selected exam using the `addScore` command. For this example, we shall add a score of `100` to the first person in the list.
          <br><br>
    * **Test case:** Similar to previous.<br>
      **Expected:** Similar to previous.

<br>

<div id="test_statistics"></div>

#### Mean and Median of Exam Scores

**More information on usage:** <a href="UserGuide.md#mean-and-median">Mean and Median of Exam Scores</a>

1. Mean and median of exam scores while all persons are displayed.

    * **Prerequisites:**
        * Ensure at least one exam is added using the `addExam` command. For this example, we shall add a new exam with name `test exam` and maximum score `100`.
        * Ensure an exam is selected using the `selectExam` command. For this example, we shall select `test exam` from above.
        * Ensure all persons are displayed using the `list` command.
          <br><br>
    * **Initially, no scores added to any persons in the list**<br>
      **Expected:** "No scores available" is displayed at the bottom, right corner of the GUI.
      <br><br>
    * **Use `addScore` to add a score of `50` to the first person in the list**<br>
      **Expected:** A mean score of `50` and a median score of `50` is displayed at the bottom, right corner of the GUI.
      <br><br>
    * **Use `addScore` to add a score of `25` to the second person in the list and a score of `27.7` to the third person in the list**<br>
      **Expected:** the calculated mean value of the three scores (rounded to two decimal places), `50`, `25` and `27.7`, and the median of the three scores, are displayed at the bottom, right corner of the GUI.

<br>

--------------------------------------------------------------------------------------------------------------------

<div id="appendix_g"></div>

### Appendix G: Effort

This sections aims to showcase the effort put into Avengers Assemble by our team.
We will highlight the difficulty level, challenges faced, and effort required in this project.

<br>

#### Difficulty Level

On top of the `Person` entity originally implemented by AB3, Avengers Assemble also incorporates an additional entity of
`Exam`, with `Score` serving as a connection between the two entities.
With this additional entity added, considerations had to be made regarding the implementation of
different features, interactions between each entity, and the management and storage of these
entities. The consideration of these factors turned out to be more challenging than initially anticipated.

Moreover, in addition to enhancing the original features of AB3 to cater to our target users, Avengers Assemble also introduces
many new commands to improve the usability of our application, as well as to handle the diverse behaviours and interactions
of `Person` and `Exam`. This required a significant amount of effort to ensure that the new features were
implemented correctly and seamlessly integrated with the existing features.

Compared to the individual project, the group project was lower in intensity for each of us in terms of lines of code,
but the coordination and communication required to ensure that the features were implemented correctly and
seamlessly integrated with the existing features added a layer of complexity to the project.

<br>

#### Effort Required

##### Enhancements to Existing Features

**Addition of New Fields to Persons**<br>
New fields such as recitation, studio, matriculation number, was added to persons to align with the context of our application.

**Find**<br>
Our team improved on the existing `find` command of AB3 to allow for more flexibility. With the new improvements, users
can now find not only based on the name field of persons, but also specify their search based on other fields such as
`email` and `recitation`. With the addition of the exam score features, we also adapted our `find` command to allow users
to filter out persons less than or more than a specified score, revamping the way `find` is used and handled.

**Automatic Tagging of Persons**<br>
In the context of our application, it is mainly used to store students', instructors' and teaching assistants' contacts.
Hence, on top of the original behaviour of the tag feature, we adapted it to automatically tag contacts with a
matriculation number as students.

**User Interface**<br>
Enhancements were made to the user interface to improve the user experience. The structure of the user interface was
modified to accommodate the new features, and the theme of the application was changed to follow the theme of the
course that we were developing the application for. Furthermore, the logic for the updating of user interface was also
modified to a more developer-friendly approach which would allow developers to understand and modify the user interface
more easily.

##### New Features

**Copy**<br>
Our team introduced a new copy command which allows for users to copy the email addresses of the currently displayed persons.
This is to cater to the context of our application, assisting head tutors with the task of making mass announcements.

**Import and Export**<br>
To facilitate the handling and managing of large amounts of information, our group introduced the import and export feature to
allow for flexible data movement externally and internally. These features required extensive effort due to how bug prone
they were. This is elaborated upon in the challenges section below.

**Exams and Exams Scores**<br>
The implementation of the exam and exam score features was the most significant addition to our application, requiring adjustments to existing features and the
introduction of many new commands to handle and manage the addition of exams and exam features. This feature was the most
complex and required the most effort to implement, as it involved the introduction of a new entity, `Exam`, and the management
of scores for each person for each exam. This is further elaborated upon in the challenges section below.

<br>

#### Challenges Faced

##### Understanding the Existing Codebase
One of the challenges we faced was understanding the existing codebase of AB3. We had to familiarize ourselves with the
structure of the codebase, the interactions between the different classes, and the existing features of AB3. This required
us to spend time reading through the code, discussing the existing features, and identifying potential areas where
conflicts might arise when adding new features. We also had to consider how to integrate our new features using the existing
structure in AB3, and how to ensure that the new features did not conflict with the existing features.

##### Considerations for New Entity `Exam` and its Interactions with `Person`
Our team wanted to implement a feature that would allow users to manage and store exam scores for each person.
It was clear from the start that this would require the introduction of a new entity, `Exam`, to store information about
each exam. However, we found that there was a challenge in determining how to connect the `Person` entity with the `Exam` entity, and how to
manage and store the scores for each person for each exam. This required careful consideration and planning to ensure that
the interactions between the two entities were seamless and intuitive for users. We also had to consider how to handle the
storage of these entities and how to manage the data effectively.

**Limited User Interface Space for Score Interaction** <br>

One of the greatest challenges was designing a user-friendly interface for score
interaction within the limited screen space. We had to devise intuitive methods for users to view, input and manage the scores
of various exams, without overwhelming the interface. This proved to be a greater challenge than initially anticipated,
as we had to consider trade offs between functionality and user experience. Lowering the complexity of the interface
would result in an interface that is easier to read, but might not provide all the necessary information at a glance and
require more user interactions to access the information. On the other hand, a more complex interface would provide more
information at a glance, but might overwhelm users with too much information. Striking a balance between these two
trade-offs was a challenge that required extended discussions and iterations before arriving at a solution that we were
satisfied with: the selection system for exams.

**Implementation of Exam and Exam Score Features** <br>

After coming to a concensus with regards to the user interface, implemetation for exam features seemed straightforward.
However, it turned out to be a lot more complex to implement than initially anticipated. Our exam features consisted
of many subfeatures which included the management of exams, the management of scores, the storage of scores in persons,
and the importing of scores. As we were working in a collaborative environment, we had to consider how to distribute
the workload in a manner that would prevent conflicts.
This required early discussions of the structure of the exam and score features, and how they would interact with the existing features of AB3.
We drafted up diagrams to visualize the interactions between each feature. This helped us to identify potential conflicts
early on and resolve them through distributing the workload effectively and meeting regularly to discuss progress and issues.

**Data Management for Exams and Scores** <br>

Handling the data for exams and scores was another challenge that we faced. We had to consider how to store the data for
each exam, how to store the scores for each person for each exam, and how to manage the data effectively.
The storage for exams was relatively straightforward, as we could create an additional list in the `AddressBook` class to store
the exams. However, the storage for scores was more complex.. We had to decide whether to store all the exam score data
in corresponding `Exam` objects, or store each persons' exam scores in their corresponding `Person` objects.

There was once again another trade-off to consider: storing all exam score data in the `Exam` objects would make it
easier to implement exam operations, but would require more complex interactions between the score and person objects.
On the other hand, storing each person's score in their corresponding `Person` object would make it easier to implement
operations on persons, but would require more complex interactions for exam management. We had to consider the pros and cons
of each approach, before deciding on the latter approach, as we concluded that our application was more person-centric.

##### Bug Fixing and Testing
A significant challenge we faced was the identification and resolution of bugs. Unit tests for our own features were
relatively straightforward to implement, but we found that identifying edge cases proved to be tricky. Certain features
were also a lot more bug prone than others, such as the import features, which required extensive testing to ensure that
all potential errors were caught and proper error messages were displayed. We also had to ensure that the application
handled these errors gracefully and did not crash when these errors occurred.

<br>

#### Achievements
Overall, our group successfully implemented the planned features while addressing bugs and managing potential feature flaws.
Despite initial hesitations about implementing significant new features like exams and exam scores, we overcame the challenge and achieved our goals.
