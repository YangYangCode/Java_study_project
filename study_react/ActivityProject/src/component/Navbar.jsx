import React from "react";
import { Link } from "react-router-dom";

function Navbar({ isLoggedIn, onLogout, userCret }) {
    return (
        <nav className="fixed top-0 left-0 w-full bg-gray-800 text-white flex justify-between items-center py-4 px-6 z-50">
            <h2 className="text-xl font-bold">活動報名</h2>
            <ul className="flex gap-6">
                <li>
                    <Link
                        to="/"
                        className="text-white hover:underline"
                    >
                        首頁
                    </Link>
                </li>
                <li>
                    <Link
                        to="/activityschedule"
                        className="text-white hover:underline"
                    >
                        活動表
                    </Link>
                </li>
                <li>
                    <Link
                        to="/classRoom"
                        className="text-white hover:underline"
                    >
                        上課教室
                    </Link>
                </li>
                <li>
                    <Link
                        to="/classType"
                        className="text-white hover:underline"
                    >
                        課程類型
                    </Link>
                </li>
                <li>
                    <Link
                        to="/fitnessInstructors"
                        className="text-white hover:underline"
                    >
                        健身教練
                    </Link>
                </li>

                {/* 僅會員 */}
                {userCret.type === "member" && (
                    <li>
                        <Link
                            to="/member"
                            className="text-white hover:underline"
                        >
                            會員資訊
                        </Link>
                    </li>
                )}

                {/* 僅教練 */}
                {userCret.type === "fitnessInstructor" && (
                    <li>
                        <Link
                            to="/"
                            className="text-white hover:underline"
                        >
                            教練資訊
                        </Link>
                    </li>
                )}

                {/* 僅管理員 */}
                {userCret.type === "activityManager" && (
                    <li>
                        <Link to="/manageractivitylist" className="text-white hover:underline">
                            活動管理
                        </Link>
                    </li>
                )}
                {userCret.type === "activityManager" && (
                    <li>
                        <Link to="/classroom/manager" className="text-white hover:underline">
                            教室管理
                        </Link>
                    </li>
                )}
                {userCret.type === "activityManager" && (
                    <li>
                        <Link to="/classtype/manager" className="text-white hover:underline">
                            課程管理
                        </Link>
                    </li>
                )}
                {userCret.type === "activityManager" && (
                    <li>
                        <Link to="/fitnessinstructor/manager" className="text-white hover:underline">
                            教練管理
                        </Link>
                    </li>
                )}
                {userCret.type === "activityManager" && (
                    <li>
                        <Link to="/member/manager" className="text-white hover:underline">
                            會員管理
                        </Link>
                    </li>
                )}
                {userCret.type === "manager" && (
                    <li>
                        <Link to="/fortest" className="text-white hover:underline">
                            修改中
                        </Link>
                    </li>
                )}


                {isLoggedIn ? (
                    <li>
                        <button
                            onClick={onLogout}
                            className="text-white bg-blue-500 hover:bg-blue-600 px-3 py-1 rounded"
                        >
                            登出
                        </button>
                    </li>
                ) : (
                    <li>
                        <Link
                            to="/login"
                            className="text-white bg-blue-500 hover:bg-blue-600 px-3 py-1 rounded"
                        >
                            登入
                        </Link>
                    </li>
                )}
            </ul>
        </nav>
    );
}

export default Navbar;
