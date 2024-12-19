import React from "react";
import { Link } from "react-router-dom";

function Navbar() {
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
                <li>
                    <Link
                        to="/manageractivitylist"
                        className="text-white hover:underline"
                    >
                        活動管理
                    </Link>
                </li>
                <li>
                    <Link
                        to="/member"
                        className="text-white hover:underline"
                    >
                        會員資訊
                    </Link>
                </li>
                <li>
                    <Link
                        to="/fortest"
                        className="text-white hover:underline"
                    >
                        修改中
                    </Link>
                </li>
                <li>
                    <Link
                        to="/login"
                        className="text-white bg-blue-500 hover:bg-blue-600 px-3 py-1 rounded"
                    >
                        登出
                    </Link>
                </li>
            </ul>
        </nav>
    );
}

export default Navbar;
