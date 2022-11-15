function deleteStudents(){
    var checkedCheckboxs = document.querySelectorAll('input[name=idStudent]:checked')
    if(checkedCheckboxs.length == 0){
        alert("Выберите хотя бы одного студента!!!")
        return;
    }

    // 1-2-5-7 - string
    var ids = ""
    for(var i = 0; i < checkedCheckboxs.length; i++){
        ids = ids + checkedCheckboxs[i].value + ",";
    }
    ids=ids.substring(0,ids.length-1);

    document.getElementById("deleteStudentHidden").value = ids;
    document.getElementById('deleteStudentForm').submit();


}
function modificationStudents(){
    var checkedCheckboxs = document.querySelectorAll('input[name=idStudent]:checked')
    if(checkedCheckboxs.length == 0||checkedCheckboxs.length > 1){
        alert("Выберите одного студента!!!")
        return;
    }

    // 1-2-5-7 - string
    var id = checkedCheckboxs[0].value



    document.getElementById("modificationStudentsHidden").value = id;
    document.getElementById('modificationStudentsForm').submit();
}
function deleteDisciplines(){
    var checkedCheckboxs = document.querySelectorAll('input[name=idDisciplin]:checked')
    if(checkedCheckboxs.length == 0){
        alert("Выберите хотя бы одну дисциплину!!!")
        return;
    }

    // 1-2-5-7 - string
    var id1 = ""
    for(var i = 0; i < checkedCheckboxs.length; i++){
        id1 = id1 + checkedCheckboxs[i].value + ",";
    }
    id1=id1.substring(0,id1.length-1);

    document.getElementById("deleteDisciplinHidden").value = id1;
    document.getElementById('deleteDisciplinForm').submit();



}
function modificationDisciplines(){
    var checkedCheckboxs = document.querySelectorAll('input[name=idDisciplin]:checked')
    if(checkedCheckboxs.length == 0||checkedCheckboxs.length > 1){
        alert("Выберите одну дисциплину!!!")
        return;
    }

    // 1-2-5-7 - string
    var id = checkedCheckboxs[0].value

    document.getElementById("modificationDisciplinHidden").value = id;
    document.getElementById('modificationDisciplinForm').submit();
}
function studentProgressFunction(){
    var checkedCheckboxs = document.querySelectorAll('input[name=idStudent]:checked')
    if(checkedCheckboxs.length == 0||checkedCheckboxs.length > 1){
        alert("Выберите одного студента!!!")
        return;
    }

    // 1-2-5-7 - string
    var id2 = checkedCheckboxs[0].value
    document.getElementById("studentProgressHidden").value = id2;
    document.getElementById('studentProgressForm').submit();
}
function progresStudents(){
    var checkedCheckboxs = document.querySelectorAll('input[name=idStudent]:checked')
    if(checkedCheckboxs.length == 0||checkedCheckboxs.length > 1){
        alert("Выберите одного студента!!!")
        return;
    }

    // 1-2-5-7 - string
    var id = checkedCheckboxs[0].value



    document.getElementById("progressStudentHidden").value = id;
    document.getElementById('progressStudentForm').submit();
}
function progresCheckStudents(){
    var checkedCheckboxs = document.querySelectorAll('input[name=idSelectedTerm]:checked')

    var idCheck = checkedCheckboxs[0].value



    document.getElementById("progresCheckStudentsHidden").value = idCheck;
    document.getElementById('progresCheckStudentsForm').submit();
}
function creatUpTerm(){
    var checkedCheckboxs = document.querySelectorAll('input[name=idDisciplin]:checked')
    var idDisciplinTerm = ""
    for(var i = 0; i < checkedCheckboxs.length; i++){
        idDisciplinTerm = idDisciplinTerm + checkedCheckboxs[i].value + ",";
    }
    idDisciplinTerm=idDisciplinTerm.substring(0,idDisciplinTerm.length-1);

    document.getElementById("creatUpTermHidden").value = idDisciplinTerm;
    document.getElementById('creatUpTermForm').submit();


}
function deleteTerm(){
    var checkedCheckboxs = document.querySelectorAll('input[name=idSelectedTerm]:checked')

    var idCheck = checkedCheckboxs[0].value



    document.getElementById("deleteCheckTermHidden").value = idCheck;
    document.getElementById('deleteCheckTermForm').submit();
}
