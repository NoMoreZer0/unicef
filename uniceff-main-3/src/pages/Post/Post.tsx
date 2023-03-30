import {useEffect, useState} from 'react';
import {styled} from '@mui/material/styles';
import Card from '@mui/material/Card';
import CardHeader from '@mui/material/CardHeader';
import CardMedia from '@mui/material/CardMedia';
import CardContent from '@mui/material/CardContent';
import CardActions from '@mui/material/CardActions';
import Collapse from '@mui/material/Collapse';
import Avatar from '@mui/material/Avatar';
import IconButton, {IconButtonProps} from '@mui/material/IconButton';
import Typography from '@mui/material/Typography';
import {red} from '@mui/material/colors';
import FavoriteIcon from '@mui/icons-material/Favorite';
import ShareIcon from '@mui/icons-material/Share';
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';
import MoreVertIcon from '@mui/icons-material/MoreVert';
import {Box, Button, Modal} from '@mui/material';
import {useForm} from 'react-hook-form';
import {FeedService} from '../../services/FeedService';

import {PostContent} from '../../types';


type Props = {
  postContent: PostContent;
};

export function Post({postContent}: Props) {

  return (
    <>
      <Card sx={{minWidth: 545, width: '70%', marginBottom: '3rem'}} >
        <CardHeader
          avatar={
            <Avatar sx={{bgcolor: '#80C342'}} aria-label="recipe">
              А
            </Avatar>
          }
          action={
            <IconButton aria-label="settings">
              <MoreVertIcon />
            </IconButton>
          }
          titleTypographyProps={{variant: 'h5'}}
          title={postContent.label}
          subheader={postContent.timestamp}
        />

        <CardContent>
          <Typography variant="body2" color="text.secondary" sx={{
            fontSize: '1.5rem'
          }}>
            {postContent.topic}
          </Typography>
        </CardContent>
      </Card>
    </>
  );
};