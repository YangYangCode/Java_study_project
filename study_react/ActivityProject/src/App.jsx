import React, { useState, useEffect } from "react";
import {
  BrowserRouter as Router,
  Routes,
  Route,
} from "react-router-dom";

import { checkLoginStatus, login, logout } from "./service/Service_AS";
import Navbar from "./component/Navbar";
import Footer from "./component/Footer";

import ActivitySchedules from "./pages/ActivitySchedule/week_ActivitySchedules";
import AddAS from "./pages/ActivitySchedule/add_ActivitySchedule";
import UpdateAS from "./pages/ActivitySchedule/upDate_ActivitySchedule";

import ClassRoom from "./pages/ClassRoom/ClassRoomCard";
import AddClassRoom from "./pages/ClassRoom/add_ClassRoom";
import UpdateClassRoom from "./pages/ClassRoom/update_ClassRoom";
import ClassRoomList from "./pages/ClassRoom/ClassRoomList";

import ClassType from "./pages/ClassType/ClassTypes";
import AddClassType from "./pages/ClassType/add_ClassType";
import ClassTypeList from "./pages/ClassType/ClassTypeList";


import FitnessInstructors from "./pages/FitnessInstructor/FitnessInstructors";
import AddFitnessInstructor from "./pages/FitnessInstructor/add_FitnessInstructor";
import FitnessInstructorList from "./pages/FitnessInstructor/FitnessInstructorList";


import ManagerActivityList from "./pages/ActivitySchedule/ActivityList";


import Member from "./pages/member/Member";
import MemberList from "./pages/member/MemberList";


import Login from "./pages/Login";
import LoginManager from "./pages/LoginManager";
import Home from "./pages/Home";

import Test from "./pages/forTest";




function App() {

  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [userCret, setUserCret] = useState({ id: "", type: "" });

  useEffect(() => {
    const initializeLoginStatus = async () => {
      try {
        const apiResponse = await checkLoginStatus(); // 使用判斷是否已登入服務方法
        setIsLoggedIn(apiResponse.data.isLoggedIn);
        setUserCret({
          id: apiResponse.data.id,
          type: apiResponse.data.type
        });
        // console.log(userCret);
      } catch (error) {
        console.error("無法檢查登入狀態:", error);
        // alert("無法連接到伺服器，請檢查網路連線或伺服器狀態。");
      }
    };

    initializeLoginStatus();
  }, []);

  const handleLogin = async (username, password, type) => {
    try {
      const data = await login(username, password, type); // 使用登入服務方法

      if (data.message === "登入成功") {
        setIsLoggedIn(true);
        alert("登入成功");
        window.location.href = "/";
      } else {
        alert("登入失敗");
      }
    } catch (error) {
      console.error("登入錯誤:", error);
    }
  };

  const handleLogout = async () => {
    try {
      const apiResponse = await logout(); // 使用登出服務方法
      setIsLoggedIn(false);
      setUserCret({ id: "", type: "" });
      alert(apiResponse.data);

      // window.location.href = "/";
      navigate("/", {
        state: { isLoggedIn, userCret }  // 传递 item 数据
      });

    } catch (error) {
      console.error("登出錯誤:", error);
    }
  };


  return (
    <>
      <Router future={{ v7_startTransition: true, v7_relativeSplatPath: true }}>
        <Navbar
          isLoggedIn={isLoggedIn}
          userCret={userCret}
          onLogout={handleLogout}
        />
        <div className="">
          <Routes>

            <Route
              path="/"
              element={<Home />}
            />

            <Route
              path="/activityschedule"
              element={<ActivitySchedules
                isLoggedIn={isLoggedIn}
                userCret={userCret}
              />}
            />
            <Route
              path="/addactivityschedule"
              element={<AddAS />}
            />
            <Route
              path="/updateactivityschedule"
              element={<UpdateAS />}
            />


            <Route
              path="/classroom"
              element={<ClassRoom />}
            />
            <Route
              path="/classroom/manager"
              element={<ClassRoomList />}
            />
            <Route
              path="/addclassroom"
              element={<AddClassRoom />}
            />
            <Route
              path="/updateclassRoom"
              element={<UpdateClassRoom />}
            />



            <Route
              path="/classtype"
              element={<ClassType />}
            />
            <Route
              path="/classtype/manager"
              element={<ClassTypeList />}
            />
            <Route
              path="/addclasstype"
              element={<AddClassType />}
            />
            <Route
              path="/updateclasstype"
              element={<UpdateClassRoom />}
            />



            <Route
              path="/fitnessinstructors"
              element={<FitnessInstructors />}
            />

            <Route
              path="/fitnessinstructor/manager"
              element={<FitnessInstructorList />}
            />

            <Route
              path="/addfitnessinstructor"
              element={<AddFitnessInstructor />}
            />
            {/* <Route
              path="/updateclassRoom"
              element={<UpdateClassRoom />}
            /> */}


            <Route
              path="/manageractivitylist"
              element={<ManagerActivityList />}
            />


            <Route
              path="/member"
              element={<Member />}
            />
            <Route
              path="/member/manager"
              element={<MemberList />}
            />


            <Route
              path="/fortest"
              element={<Test />}
            />

            <Route
              path="/login"
              element={<Login onLogin={handleLogin} setIsLoggedIn={setIsLoggedIn} setUserCret={setUserCret} />}
            />

            <Route
              path="/login/manager"
              element={<LoginManager onLogin={handleLogin} setIsLoggedIn={setIsLoggedIn} setUserCret={setUserCret} />}
            />



          </Routes>
        </div>
        {/* <Footer /> */}

      </Router >
    </>
  )
}

export default App
