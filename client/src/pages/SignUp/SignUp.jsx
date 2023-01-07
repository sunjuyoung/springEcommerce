import React, { useState } from 'react'
import './SignUp.scss';

const SignUp = () => {
   
const [formData, setFormData] = useState({
    email: "",
    username: "",
    password: "",
    confirmPassword: "",
    });

const { email, username, password, confirmPassword } = formData;

const handleChange = (event) => {
const { name, value } = event.target;
setFormData({ ...formData, [name]: value });
};

const handleSubmit = (event) => {
  event.preventDefault();
  const passwordError = verifyPasswordStrength(this.state.password);
  if (passwordError !== 'Password is strong') {
    this.setState({
      passwordError
    });
    return;
  }

const MIN_LENGTH = 8;
const MAX_LENGTH = 64;

function verifyPasswordStrength(password) {
  if (password.length < MIN_LENGTH) {
    return 'Password is too short';
  }
  if (password.length > MAX_LENGTH) {
    return 'Password is too long';
  }

  // if (!/^(?=.*[A-Z])(?=.*[a-z])(?=.*\d)(?=.*[!@#$%^&*()_+|~=`{}\[\]:";'<>,.\/?\\-]).{8,64}$/.test(password)) {
  //   return 'Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character, and must be between 8 and 64 characters long';
  // }

  if (!/[A-Z]/.test(password)) {
    return 'Password must contain at least one uppercase letter';
  }
  if (!/[a-z]/.test(password)) {
    return 'Password must contain at least one lowercase letter';
  }
  if (!/\d/.test(password)) {
    return 'Password must contain at least one number';
  }
  if (!/[!@#$%^&*()_+|~=`{}\[\]:";'<>,.\/?\\-]/.test(password)) {
    return 'Password must contain at least one special character';
  }
  return 'Password is strong';
}

  return (
    <div className="signup-form">
    <form onSubmit={handleSubmit}>
      <div className="form-group">
        <label htmlFor="email">Email:</label>
        <input
          type="email"
          id="email"
          name="email"
          value={email}
          onChange={handleChange}
          className="form-control"
        />
      </div>
      <div className="form-group">
        <label htmlFor="username">Username:</label>
        <input
          type="text"
          id="username"
          name="username"
          value={username}
          onChange={handleChange}
          className="form-control"
        />
      </div>
      <div className="form-group">
        <label htmlFor="password">Password:</label>
        <input
          type="password"
          id="password"
          name="password"
          value={password}
          onChange={handleChange}
          className="form-control"
        />
      </div>
      <div className="form-group">
        <label htmlFor="confirmPassword">Confirm Password:</label>
        <input
          type="password"
          id="confirmPassword"
          name="confirmPassword"
          value={confirmPassword}
          onChange={handleChange}
          className="form-control"
        />
      </div>
      <button type="submit" className="btn btn-primary">
        Sign Up
      </button>
    </form>
  </div>
);
};
};
export default SignUp