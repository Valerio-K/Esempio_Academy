function sayWelcome() {
    document.write("Welcome");
}

function array1() {
    var books = ["book1","book2","book3"];
    printArray(books);
}

function array2() {
    var averagePrice = 200;
    var books = new Array();
    books[0]="book1";
    books[1]="book2";
    books[2]=averagePrice;
    printArray(books);
}

function array3() {
    var books = new Array("book1","book2",5)
    printArray(books);
}

function printArray(array) {
    document.write("<table border=1>");
    document.write("<tr>");
    array.forEach(cursore=> {
        document.write("<td>");
        document.write(cursore);
        document.write("</td>");
    })
    document.write("</tr>");
    document.write("</table>");
    console.log(array)
}

function formValidate() {
    var form = document.registration;

    if (form.firstName.value=="") {
        alert("Campo First Name obbligatorio");
        form.firstName.focus();
        return false;
    }

    if (form.lastName.value=="") {
        alert("Campo Last Name obbligatorio");
        form.lastName.focus();
        return false;
    }
    
    if (form.age.value=="") {
        alert("Campo Age obbligatorio");
        form.age.focus();
        return false;
    }
    return true
}