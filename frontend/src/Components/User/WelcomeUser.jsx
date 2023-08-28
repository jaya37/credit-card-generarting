import React, { useState } from 'react'

const WelcomeUser = () => {
    const[data,setData]=useState([]);
    const user = JSON.parse(localStorage.getItem("user"));
    
    return (
        <div>
            <div className="col-md-5 col-sm-7 py-5">
                <div className="d-flex justify-content-center mt-5 py-5 px-5">
                    <div className="intro-wrap py-5 px-5 ">
                        <h1 className="fw-bold px-5 fs-1 d-flex justify-content-center text-light">
                            WELCOME
                        </h1>
                        <h1 className="fw-bold fs-1 d-flex justify-content-center text-info">
                            {user.name}
                        </h1>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default WelcomeUser;