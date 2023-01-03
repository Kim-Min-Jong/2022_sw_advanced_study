// document.querySelectorAll("tr").forEach(tr => tr.addEventListener("mouseover", function(e){
//     e.target.parentElement.style.backgroundColor = "blue";
// }));

// document.querySelector("tr").addEventListener("mouseout", function(e){
//     e.target.parentElement.style.backgroundColor = "white";
// });
function addRow() {
    let tr = document.createElement("tr");
    tr.innerHTML = `
        <tr>
            <td>1</td>
            <td>2</td>
            <td>3</td>
            <td>4</td>
        </tr>
    `
    document.querySelector("tbody").append(tr);
}