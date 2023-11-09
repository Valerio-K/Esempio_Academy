function tutorialRegistration() {
    const form=document.tutorial_registration

    //creazione Oggetto JavaScript con le info recuperate
    const formData = {
        name:form.name.value,
        technology:form.technology.value,
        description:form.description.value,
    }

    //tramite fetch() consumiamo l'operazione POST
    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
    };
    fetch('http://localhost:9090/rest/api/tutorials', options)
        .then(response => response.json())
        .then(data => console.log(data))
        .catch(error => console.error('ERRORE:', error));
    window.location.href="tutorialsList.html";
}

function tutorialsList() {

    var ajaxRequest = new XMLHttpRequest();
    ajaxRequest.onreadystatechange = function () {
    
        if (ajaxRequest.readyState == 4) {
            if (ajaxRequest.status == 200) {
    
                var tutorials = JSON.parse(ajaxRequest.responseText);
    
                document.write("<table border=1>");
                document.write("<tr>");
                document.write("<th>");
                document.write("Name");
                document.write("</th>");
                document.write("<th>");
                document.write("Technology");
                document.write("</th>");
                document.write("<th>");
                document.write("Description");
    
                tutorials.forEach(tutorial => {
                    document.write("<tr>");
                    document.write("<td>");
                    document.write(tutorial.name);
                    document.write("</td>");
                    document.write("<td>");
                    document.write(tutorial.technology);
                    document.write("</td>");
                    document.write("<td>");
                    document.write(tutorial.description);
                    document.write("</td>");
                    document.write("<td>");
                    document.write("<a  href ='javascript:void(0)' onclick='removeTutorial(\"" + 
                        tutorial.id + "\")'>delete</a>")
                    document.write("</td>");
                    document.write("<td>");
                    document.write("<a  href ='javascript:void(0)' onclick='toUpdateTutorial(\"" + 
                        tutorial.id + "\")'>update</a>")
                    document.write("</td>");
                    document.write("</tr>");                        
                });
                document.write("</table>");
                document.write("<br/>");
                document.write('<a href="tutorialRegistration.html">Register another tutorial</a>');
            }
        }
    }
    ajaxRequest.open('GET', 'http://localhost:9090/rest/api/tutorials');
    ajaxRequest.send();
}

function removeTutorial(id) {
    const options = {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        }
    };


    fetch('http://localhost:9090/rest/api/tutorials/id/' + id, options)
        .then(response => response.json())
        .then(data => console.log(data))
        .catch(error => console.error('ERRORE:', error));

        window.location.href = "tutorialsList.html";
}

function toUpdateTutorial(id) {
    
    const options = {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    };

    fetch('http://localhost:9090/rest/api/tutorials/id/' + id, options)
        .then(response => response.json())
        .then(data => {
            console.log(data);
            updateTutorial(data);
        })
        .catch(error => console.error('ERRORE:', error));
}

function updateTutorial(data){

    document.write('<br><br><br>');
    document.write('<form name="tutorial_update">');

    document.write('<label for="Id">Id:</label>');
    document.write('<input type="text" disabled="true" id="id" value="'+data.id+'"><br><br>');

    document.write('<label for="Name">Name:</label>');
    document.write('<input type="text" id="name"  value="'+data.name+'"><br><br>');

    document.write('<label for="Technology">Technology:</label>');
    document.write('<input type="text" id="technology"  value="'+data.technology+'"><br><br>');

    document.write('<label for="Description">Description:</label>');
    document.write('<input type="text" id="description"  value="'+data.description+'"><br><br>');

    document.write('<input type="submit" value="Update" onclick="tutorialUpdate()">');
    document.write('</form>');
}

function tutorialUpdate() {
    const form=document.tutorial_update;

    const formData = {
        id: form.id.value,
        name: form.name.value,
        technology: form.technology.value,
        description: form.description.value
    };

    //Imposta le opzioni per la richiesta POST
    const options = {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
    };

    fetch('http://localhost:9090/rest/api/tutorials', options)
        .then(response => response.json())
        .then(data => console.log(data))
        .catch(error => console.error('ERRORE:', error));
    window.location.href = "tutorialsList.html";
}