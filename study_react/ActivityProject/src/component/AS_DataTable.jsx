import React, { useEffect } from 'react';
import $ from "jquery";
import 'datatables.net-dt/css/dataTables.dataTables.min.css';
import "datatables.net";
import Button from '@mui/material/Button';
import { Link, useNavigate } from 'react-router-dom';


const ActivityScheduleDataTable = ({ activities }) => {

    // console.log(activities);         // 資料陣列

    const navigate = useNavigate();  // 获取 navigate 函数

    // 按钮点击处理函数
    const handleEditClick = (item) => {
        console.log("table: ",item);
        
        // 通过 navigate 跳转到 "/updateactivityschedule" 页面，并传递 state
        navigate("/updateactivityschedule", {
            state: { item }  // 传递 item 数据
        });
    };


    // 初始化 DataTable
    useEffect(() => {
        if (activities.length > 0) {
            const table = $("#example").DataTable();
            return () => {
                // 在組件卸載時銷毀 DataTable，避免多次初始化
                table.destroy();
            };
        }
    }, [activities]);

    const tableCellClasses = "text-center py-2 px-4 border-r border-gray-300";

    return (
        <div className="min-h-screen flex justify-center">
            <div className="w-[90vw]">
                <Link
                    to="/addactivityschedule"
                    className="bg-green-500 text-white px-4 py-2 mr-2 rounded-md hover:bg-green-600 hover:underline inline-block text-center"
                >
                    新增活動
                </Link>

                <table id="example" className="display border w-full table-auto">
                    <thead className='border-r border-gray-900'>
                        <tr>
                            <th style={{ textAlign: 'center', verticalAlign: 'middle' }}
                                className={tableCellClasses}>
                                管理員
                            </th>
                            <th style={{ textAlign: 'center', verticalAlign: 'middle' }}
                                className={tableCellClasses}>
                                活動編號
                            </th>
                            <th style={{ textAlign: 'center', verticalAlign: 'middle' }}
                                className={tableCellClasses}>
                                上課日期
                            </th>
                            <th style={{ textAlign: 'center', verticalAlign: 'middle' }}
                                className={tableCellClasses}>
                                上課時段
                            </th>
                            <th style={{ textAlign: 'center', verticalAlign: 'middle' }}
                                className={tableCellClasses}>
                                帶課教練
                            </th>
                            <th style={{ textAlign: 'center', verticalAlign: 'middle' }}
                                className={tableCellClasses}>
                                課程類型
                            </th>
                            <th style={{ textAlign: 'center', verticalAlign: 'middle' }}
                                className={tableCellClasses}>
                                上課教室
                            </th>
                            <th style={{ textAlign: 'center', verticalAlign: 'middle' }}
                                className={tableCellClasses}>
                                報名上限
                            </th>
                            <th style={{ textAlign: 'center', verticalAlign: 'middle' }}
                                className={tableCellClasses}>
                                成員列表
                            </th>
                            <th style={{ textAlign: 'center', verticalAlign: 'middle' }}
                                className={tableCellClasses}>
                                詳細資訊
                            </th>
                            <th style={{ textAlign: 'center', verticalAlign: 'middle' }}
                                className={tableCellClasses}>
                                活動修改
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        {activities.map((item) => (
                            <tr key={item.id + 1}>
                                <td className={tableCellClasses}>{item.activityManager.name}</td>
                                <td className={tableCellClasses}>{item.id}</td>
                                <td className={tableCellClasses}>{item.date}</td>
                                <td className={tableCellClasses}>{item.classTime}</td>
                                <td className={tableCellClasses}>{Object.values(item.fitnessInstructors).join(", ")}</td>
                                <td className={tableCellClasses}>{item.classType.name}</td>
                                <td className={tableCellClasses}>{item.classRoom.name}</td>
                                <td className={tableCellClasses}>{item.maxSignNumber}</td>
                                <td className={tableCellClasses}>
                                    <Button className="bg-blue-500 text-white px-4 py-2 mr-2 rounded-md">
                                        人數：{Object.keys(item.signedMembers).length}
                                    </Button>
                                </td>
                                <td className={tableCellClasses}>
                                    <Button className="bg-blue-500 text-white px-4 py-2 mr-2 rounded-md">
                                        information
                                    </Button>
                                </td>
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
export default ActivityScheduleDataTable;



