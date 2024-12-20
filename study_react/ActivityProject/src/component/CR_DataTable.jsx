import React, { useEffect } from 'react';
import $ from "jquery";
import 'datatables.net-dt/css/dataTables.dataTables.min.css';
import "datatables.net";
import Button from '@mui/material/Button';
import { Link, useNavigate } from 'react-router-dom';


const ClassRoomScheduleDataTable = ({ classRooms }) => {

    // console.log(activities);         // 資料陣列

    const navigate = useNavigate();  // 获取 navigate 函数

    // 按钮点击处理函数
    const handleEditClick = (item) => {
        console.log("table: ", item);

        // 通过 navigate 跳转到 "/updateactivityschedule" 页面，并传递 state
        navigate("/updateclassRoom", {
            state: { item }  // 传递 item 数据
        });
    };


    // 初始化 DataTable
    useEffect(() => {
        if (classRooms.length > 0) {
            const table = $("#example").DataTable();
            return () => {
                // 在組件卸載時銷毀 DataTable，避免多次初始化
                table.destroy();
            };
        }
    }, [classRooms]);

    const tableCellClasses = "text-center py-2 px-4 border-r border-gray-300";

    return (
        <div className="min-h-screen flex justify-center">
            <div className="w-[90vw]">
                <Link
                    to="/addclassroom"
                    className="bg-green-500 text-white px-4 py-2 mr-2 rounded-md hover:bg-green-600 hover:underline inline-block text-center"
                >
                    新增教室
                </Link>

                <table id="example" className="display border w-full table-auto">
                    <thead className='border-r border-gray-900'>
                        <tr>
                            <th style={{ textAlign: 'center', verticalAlign: 'middle' }}
                                className={tableCellClasses}>
                                教室名稱
                            </th>
                            <th style={{ textAlign: 'center', verticalAlign: 'middle' }}
                                className={tableCellClasses}>
                                人數上限
                            </th>
                            <th style={{ textAlign: 'center', verticalAlign: 'middle' }}
                                className={tableCellClasses}>
                                可辦理活動
                            </th>
                            <th style={{ textAlign: 'center', verticalAlign: 'middle' }}
                                className={tableCellClasses}>
                                近期活動
                            </th>
                            <th style={{ textAlign: 'center', verticalAlign: 'middle' }}
                                className={tableCellClasses}>
                                教室調整
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        {classRooms.map((item) => (
                            <tr key={item.id + 1}>
                                <td className={tableCellClasses}>{item.name}</td>
                                <td className={tableCellClasses}>{item.name}</td>
                                <td className={tableCellClasses}>{item.name}</td>
                                <td className={tableCellClasses}>{item.classRoomSize}</td>
                                <td className="text-center py-2 px-4">
                                    <button
                                        className="bg-blue-500 text-white px-4 py-2 mr-2 rounded-md"
                                        onClick={() => handleEditClick(item)}  // 传递 item
                                    >
                                        修改
                                    </button>
                                    <button
                                        className="bg-red-500 text-white px-4 py-2 rounded-md"
                                        onClick={() => console.log(item)}
                                    >
                                        刪除
                                    </button>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
            </div>
        </div>
    );
};
export default ClassRoomScheduleDataTable;



