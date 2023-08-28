import axios from "axios";
import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";

const CardResponse = () => {
  const [data, setData] = useState([]);
  const navigate = useNavigate();
  const param = JSON.parse(localStorage.getItem("user"));
  console.log(param);
  const getData = async () => {
    try {
      const res = await axios.get(
        `http://localhost:8080/api/v1/card/${param.id}`
      );
      console.log(res.data, "DATA");
      setData(res.data);
    } catch {
      alert("something went wrong");
    }
  };
  useEffect(() => {
    getData();
  }, []);
  return (
    <div>
      <div className=" flex justify-start ">
        <h2>Card Details</h2>
      </div>
      <table className="  table table-striped table-bordered  w-75 ">
            <thead>
              <tr>
                <th scope="col">S.No</th>
                <th scope="col">BankName</th>
                <th scope="col">UserName</th>
                <th scope="col">CardNumber</th>
                <th scope="col">ExpiryDate</th>
                <th scope="col">CVV</th>
                <th scope="col">PIN</th>
              </tr>
            </thead>
            <tbody>
              {data.map((item, Index) => {
                return (
                  <tr className="w-10 h-10">
                    <td>{item.id}</td>
                    <td>{item.bankName}</td>
                    <td>{item.userName}</td>
                    <td>{item.cardNumber}</td>
                    <td>{item.expiryDate}</td>
                    <td>{item.cvv}</td>
                    <td>{item.pin}</td>
                  </tr>
                );
              })}
            </tbody>
          </table>
    </div>
  );
};

export default CardResponse;
