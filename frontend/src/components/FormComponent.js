import React from "react"
import axios from "axios"

export default class FormComponent extends React.Component {

  constructor(props) {
    super(props)
    this.state = {
      numberField: ""
    }
  }

  handleChange(e) {
    this.setState({numberField: e.target.value})
  }

  postContent() {

    let body = {
      number: this.state.numberField,
    }

    axios({
      method: "post",
      url: "http://localhost:8080/checker",
      data: body,
    })
      .then(function (response) {
        alert("Is it prime? " + response.data["isPrime"]);
        console.log(response);
      })
      .catch(function (response) {
        alert("An error occurred")
        console.log(response);
      });
  }

  render() {
    return(
      <div className="sm:flex">
        <label htmlFor="numberField" className="sr-only">Number to check</label>
        <input id="numberField" name="numberField" type="number" required
               className="w-full border-white px-5 py-3 placeholder-warm-gray-500 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-offset-cyan-700 focus:ring-white rounded-md"
               placeholder="Enter a number"
               min="0"
               value={this.state.numberField} onChange={this.handleChange.bind(this)}
        />
        <button onClick={this.postContent.bind(this)}
                className="mt-3 w-full flex items-center justify-center px-5 py-3 border border-transparent text-base font-medium rounded-md text-white bg-green-400 hover:bg-green-500 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-offset-cyan-700 focus:ring-green-400 sm:mt-0 sm:ml-3 sm:w-auto sm:flex-shrink-0">
          Check
        </button>
      </div>
    )
  }

}
