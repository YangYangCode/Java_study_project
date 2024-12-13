import React from 'react';
import Card from '@mui/material/Card';
import CardActions from '@mui/material/CardActions';
import CardContent from '@mui/material/CardContent';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';

const CardItem = () => {

    // 1. 製作Card

    const f_data = [
        {
            id: 1, className: "空中瑜珈", infornation: "aaaaaaaaaa", image: "Image"
        },
        {
            id: 2, className: "瑜珈", infornation: "bbbbbbbbbb", image: "Image"
        },
    ]

    return (
                        // 最小寬度
        <Card sx={{ minWidth: 275 }}>       
            <CardContent>
                <Typography gutterBottom sx={{ color: 'text.secondary', fontSize: 14 }}>
                    {f_data[0].image}
                </Typography>
                    {f_data[0].className}
            </CardContent>
            <CardActions>
                <Button size="small">information</Button>
            </CardActions>
        </Card>
    );
};



export default CardItem;

