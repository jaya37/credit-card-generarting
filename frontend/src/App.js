import './App.css';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import AdminHome from './Components/Admin/AdminHome';
import Index from './Components/Pages/Index';
import Login from './Components/Pages/Login';
import AddUser from './Components/Admin/AddUser';
import UpdateUser from './Components/Admin/updateUser';
import UserHome from './Components/User/UserHome';
import ViewCreditCardPartners from './Components/Admin/ViewCreditCardPartners';
import { ToastContainer, toast } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import AddAccount from './Components/User/AddAccount';
import Register from './Components/Pages/Register';
import PartnerHome from './Components/Partner/PartnerHome';
import BankHome from './Components/Bank/BankHome';
import AccountRequests from './Components/Bank/AccountRequests';
import BankProfile from './Components/Bank/BankProfile';
import ViewBank from './Components/User/ViewBank';
import ViewResponse from './Components/User/ViewResponse';
import RiseQuestion from './Components/User/RaiseQuestion';
import AddQuestion from './Components/User/AddQuesiton';
import SubmitAnswer from './Components/Admin/SubmitAnswer';
function App() {
  return (
    <>
      <ToastContainer />
      <Router>
        <Routes>
          <Route path='/' element={<Index />} />
          <Route path='/adminHome' element={<AdminHome />} />
          <Route path='/login' element={<Login />} />
          <Route path='/addUser' element={<AddUser />} />
          <Route path='/updateUser/:id' element={<UpdateUser />} />
          <Route path='/userHome' element={<UserHome />} />
          <Route path='/viewCreditCardPartners' element={<ViewCreditCardPartners />} />
          <Route path='/addAccount' element={<AddAccount/>}/>
          <Route path='/register' element={<Register/>}/>
          <Route path='/partnerhome' element={<PartnerHome/>}/>
          <Route path='/bankhome' element={<BankHome/>}/>
          <Route path='/accountrequests' element={<AccountRequests/>}/>
          <Route path='/bankprofile' element={<BankProfile/>}/>
          <Route path='/viewbank' element={<ViewBank/>}/>
          <Route path='/viewresponse' element={<ViewResponse/>}/>
          <Route path='/addQuestion' element={<AddQuestion/>}/>
          <Route path='/submitanswer/:id' element={<SubmitAnswer/>}/>
        </Routes>
      </Router>
    </>
  );
}

export default App;
