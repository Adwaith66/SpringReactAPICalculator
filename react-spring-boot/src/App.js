import { useEffect, useState } from "react";
import CalculatorService from "./services/CalculatorService";
import 'bootstrap/dist/css/bootstrap.min.css'
import "./App.css"

const App = () => {
  const [result, setResult] = useState([])
  const [formValues, setFormValues] = useState([{equation: "", result: ""}])

  let handleChange = (i, e) => {
    let newFormValues = [...formValues];
    newFormValues[i][e.target.name] = e.target.value;
    setFormValues(newFormValues);
  }
  let handleSubmit = (event) => {
    event.preventDefault();
     CalculatorService.getAPIResponse(formValues['0'].equation).then(response =>{
      setResult(response.data)

      let resultBox = document.getElementById("result")
      if (response.data){
        resultBox.value = response.data
      }
      else{
        resultBox.value = response

      }
    })
}
  
  return (
    <div class="p-3 mb-2 bg-transparent text-dark">
      <div className = "mainHeading">
      <h1>Calculator API</h1>
      </div>
     
    <div className = "formSizing">
    <form onSubmit={handleSubmit}>
    {formValues.map((element, index) => (
      <div className="form-inline" key={index}>
        <label>Expression</label>
        <input type="text" name="equation" value={element.equation || ""} onChange={e => handleChange(index, e)} />
        <label>Result</label>
        <input id = "result" readOnly type="text" name="result" value={element.result || ""} />
      </div>
    ))}
    <div className="button-section">
        <button className="button submit" class="btn btn-dark" type="submit">calculate</button>
  
    </div>
</form>
</div>
</div>
  );

}
export default App;