import React from 'react';
import './App.css'


class App extends React.Component {

  constructor(props) {
    super(props);
    this.state = {
      username: '',
      password: '',
      description: '',
      gender: -1,
      marStatus: -1,
      language: [],
    };
    this.onHandleChange = this.onHandleChange.bind(this);
    this.onHandleSubmit = this.onHandleSubmit.bind(this);
  }

  onHandleChange(event) {
    var target = event.target;
    var name = target.name;
    var value = target.value;
    var checkedLanguages = this.state.language;

    if (target.name == 'language') {

      if (target.checked) {
        checkedLanguages.push(value);
      } else {
        const index = checkedLanguages.indexOf(value);
        if (index !== -1) {
          checkedLanguages.splice(index, 1);
        }
      }

      value = checkedLanguages;
    }
    
    this.setState({
      [name]: value
    })

  }

  onHandleSubmit(event) {
    event.preventDefault();
    console.log(this.state);
  }

  render() {
    return (
      <div className='container mt-30'>
        <div className='row'>
          <div className='col-xs-8 col-sm-8 col-md-8 col-lg-8'>
            <div className='panel panel-primary'>
              <div className='panel-heading'>
                <h3 className='panel-title'>Form</h3>
              </div>
              <div className='panel-body'>

                <form onSubmit={this.onHandleSubmit}>

                  <div className='form-group'>
                    <label>Username: </label>
                    <input type='text'
                      className='form-control'
                      name='username'
                      onChange={this.onHandleChange}
                      value={this.state.username} />
                  </div>

                  <div className='form-group'>
                    <label>Password: </label>
                    <input type='password'
                      className='form-control'
                      name='password'
                      onChange={this.onHandleChange}
                      value={this.state.password} />
                  </div>

                  <div className='form-group'>
                    <label>Description: </label>
                    <textarea
                      name='description'
                      className='form-control'
                      rows='3'
                      onChange={this.onHandleChange}
                      value={this.state.description} >
                    </textarea>
                  </div>

                  <label>Gender: </label>
                  <select
                    className='form-control'
                    value={this.state.gender}
                    onChange={this.onHandleChange}
                    name='gender'>
                    <option value={-1}>-- Gender --</option>
                    <option value={0}>Female</option>
                    <option value={1}>Male</option>
                  </select>
                  <br />



                  <label>Marital status: </label>
                  <div className='maritalStatus'>
                    <label>
                      <input type="radio" name='marStatus' value="0"
                        onChange={this.onHandleChange} />
                      <span>Single</span>
                    </label>

                    <label>
                      <input type="radio" name='marStatus' value="1"
                        onChange={this.onHandleChange} />
                      <span>Married</span>
                    </label>

                    <label>
                      <input type="radio" name='marStatus' value="2"
                        onChange={this.onHandleChange} />
                      <span>Engaged</span>
                    </label>
                  </div>
                  <br />

                  <label>Languages: </label>
                  <div className='language'>
                    <label>
                      <input type="checkbox" name='language' value="English"
                        onChange={this.onHandleChange} />
                      <span>English</span>
                    </label>

                    <label>
                      <input type="checkbox" name='language' value="Tiếng Việt"
                        onChange={this.onHandleChange} />
                      <span>Tiếng Việt</span>
                    </label>

                    <label>
                      <input type="checkbox" name='language' value="Español"
                        onChange={this.onHandleChange} />
                      <span>Español</span>
                    </label>
                  </div>
                  <br />

                  <button type='submit' className='btn btn-primary'>Lưu lại</button>
                  <button type='reset' className='btn btn-default ml-30'>Tạo lại</button>
                </form>

              </div>
            </div>
          </div>
        </div>
      </div>
    );
  }
  
}

export default App;
